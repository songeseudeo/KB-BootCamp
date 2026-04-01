<template>
    <div class="tab">
        <h1>미드웨이 해전 — 유저별 게시글 수</h1>

        <!-- 현재 시간 표시 (렌더링 확인용) -->
        <div>{{ (new Date()).toTimeString() }}</div>

        <!-- 데이터 준비된 이후에만 차트 렌더링 -->
        <Bar v-if="loaded" :data="barData" :options="barOptions" />
        <Line v-if="loaded" :data="lineData" :options="lineOptions" />
    </div>
</template>

<script>
// vue-chartjs 컴포넌트 (Chart.js를 Vue 컴포넌트로 감싼 것)
import { Bar, Line } from 'vue-chartjs'

// Chart.js 구성 요소 (v3 이상은 반드시 register 필요)
import {
    Chart as ChartJS,
    BarElement,
    LineElement,
    PointElement,
    CategoryScale,
    LinearScale,
    Tooltip,
    Legend,
    Title
} from 'chart.js'

// 사용할 차트 요소 등록 (필수)
ChartJS.register(
    BarElement,
    LineElement,
    PointElement,
    CategoryScale,
    LinearScale,
    Tooltip,
    Legend,
    Title
)

export default {
    name: 'MidwayTabChart',

    // 템플릿에서 사용할 차트 컴포넌트 등록
    components: { Bar, Line },

    data() {
        return {
            // 마지막 데이터 호출 시간 (캐싱용)
            lastFetched: null,

            // 중복 API 호출 방지
            isLoading: false,

            // 데이터 로딩 완료 여부 (렌더 제어)
            loaded: false,

            // 차트 데이터 (reactive)
            barData: null,
            lineData: null,

            // Bar 차트 옵션 (Chart.js 옵션)
            barOptions: {
                scales: {
                    y: { beginAtZero: true } // Y축 0부터 시작
                }
            },

            // Line 차트 옵션
            lineOptions: {
                responsive: true,
                plugins: {
                    legend: { position: 'top' }, // 범례 위치
                    title: {
                        display: true,
                        text: '유저별 할일 완료/미완료 현황'
                    }
                }
            }
        }
    },

    // 최초 컴포넌트 생성 시 실행
    async mounted() {
        await this.loadChart()
        this.lastFetched = Date.now() // 최초 호출 시간 기록
    },

    // keep-alive 환경에서 탭 복귀 시 실행
    async activated() {
        const now = Date.now()

        // 로딩 중이면 중복 실행 방지
        if (this.isLoading) return

        // 1분 이상 지난 경우만 재호출 (캐싱)
        if (!this.lastFetched || now - this.lastFetched > 60000) {
            await this.loadChart()
            this.lastFetched = now
        }
    },

    methods: {
        async loadChart() {
            // 중복 호출 방지
            if (this.isLoading) return
            this.isLoading = true

            try {
                // 테스트용 API 
                const users = await fetch('https://jsonplaceholder.typicode.com/users').then(r => r.json())
                const posts = await fetch('https://jsonplaceholder.typicode.com/posts').then(r => r.json())
                const todos = await fetch('https://jsonplaceholder.typicode.com/todos').then(r => r.json())

                // X축 라벨 (유저 이름)
                const labels = users.map(u => u.name)

                // 유저별 게시글 개수
                const counts = users.map(u =>
                    posts.filter(p => p.userId === u.id).length
                )

                // 유저별 완료된 할일 수
                const completedCounts = users.map(u =>
                    todos.filter(t => t.userId === u.id && t.completed).length
                )

                // 유저별 미완료 할일 수
                const uncompletedCounts = users.map(u =>
                    todos.filter(t => t.userId === u.id && !t.completed).length
                )

                // Bar 차트 데이터 (게시글 수)
                this.barData = {
                    labels,
                    datasets: [
                        {
                            label: '게시글 수',
                            data: counts
                        }
                    ]
                }

                // Line 차트 데이터 (완료/미완료)
                this.lineData = {
                    labels,
                    datasets: [
                        {
                            label: '완료',
                            data: completedCounts,
                            borderColor: 'rgba(54, 162, 235, 1)',
                            backgroundColor: 'rgba(54, 162, 235, 0.2)'
                        },
                        {
                            label: '미완료',
                            data: uncompletedCounts,
                            borderColor: 'rgba(255, 99, 132, 1)',
                            backgroundColor: 'rgba(255, 99, 132, 0.2)'
                        }
                    ]
                }

                // 데이터 준비 완료 → 차트 렌더링 가능
                this.loaded = true

            } catch (e) {
                console.error(e)
            } finally {
                // 로딩 상태 해제 (성공/실패 관계없이)
                this.isLoading = false
            }
        }
    }
}
</script>

<!-- https://www.chartjs.org/docs/latest/getting-started/
https://vue-chartjs.org/examples/ -->

<!-- https://www.chartjs.org/docs/master/samples/line/interpolation.html -->