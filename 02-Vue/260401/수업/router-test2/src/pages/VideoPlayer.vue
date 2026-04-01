<template>
    <div class="modal">
        <div class="box">
            <div class="heading">
                <span class="title">:: {{ videoInfo.video.title }}</span>
                <span class="category"> ( {{ videoInfo.video.category }} ) </span>
                <!-- 닫기 버튼 (영상 정지 + 모달 닫기 역할) -->
                <span
                    class="float-end badge bg-secondary pointer"
                    @click="stopVideo"
                >
                    X
                </span>
            </div>

            <!-- 유튜브 플레이어 영역
                     ref="playerRef"                  플레이어 인스턴스 참조 (JS에서 제어용) 
                    :videoid="videoInfo.video.id"     재생할 유튜브 영상 ID 
                    :autoplay="1"                     자동 재생 
                    :controls="1"                     컨트롤 표시 
                    @ended="playNext"                 영상 끝나면 다음 영상 재생 --> 
            <div class="player">
                <YoutubeVue3
                     ref="playerRef"                 
                    :videoid="videoInfo.video.id"   
                    :autoplay="1"                  
                    :controls="1"                  
                    @ended="playNext"             
                />
            </div>
            <div>
                <div>
                    <i class="fa fa-backward ml-2 pointer" @click="playPrev"></i>
                    <i class="fa fa-stop ml-2 pointer" @click="stopVideo"></i>
                    <i class="fa fa-forward ml-2 pointer" @click="playNext"></i>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>

// router.push() 로 URL이 변경되면
// onBeforeRouteUpdate() 가 실행되어
// 영상 정보를 다시 계산한다.
import { reactive, ref, inject } from 'vue'
import { useRoute, useRouter, onBeforeRouteUpdate, onBeforeRouteLeave } from 'vue-router'
import { YoutubeVue3 } from 'youtube-vue3'

// App.vue에서 provide한 videos 데이터를 주입
// inject('videos', []) → provide가 없으면 기본값 [] 사용
const videos = inject('videos', [])

// 유튜브 플레이어 컴포넌트 인스턴스에 직접 접근하기 위한 template ref
// playerRef.value.player.stopVideo() 처럼 플레이어 메서드를 직접 호출할 때 사용
const playerRef = ref(null)

const currentRoute = useRoute()
const router = useRouter()

// 이전/다음 영상 ID를 담을 변수
let videoInfo, currentIndex, prevVideoId, nextVideoId

// 현재 URL의 params.id와 일치하는 영상을 찾아 반응형 객체로 관리
videoInfo = reactive({
    video: videos.find((v) => v.id === currentRoute.params.id)
})

// params.id로 현재 재생할 영상을 찾고
// 이전/다음 영상 ID를 미리 계산해두는 함수
const getNavId = (to) => {
    videoInfo.video = videos.find((v) => v.id === to.params.id)
    currentIndex = videos.findIndex((v) => v.id === videoInfo.video.id)
    // 이전 영상이 없으면 null
    prevVideoId = videos[currentIndex - 1] ? videos[currentIndex - 1].id : null
    // 다음 영상이 없으면 null
    nextVideoId = videos[currentIndex + 1] ? videos[currentIndex + 1].id : null
}

// 컴포넌트가 처음 마운트될 때 현재 라우트 정보로 영상 및 이전/다음 ID 초기화
getNavId(currentRoute)

// 정지 버튼: 플레이어를 직접 정지시키고 영상 목록 페이지로 이동
const stopVideo = () => {
    playerRef.value.player.stopVideo()
    router.push({ name: 'videos' })
}

// 다음 영상 버튼
// router.push() → URL 변경 → onBeforeRouteUpdate 실행 → getNavId()로 영상 정보 갱신
const playNext = () => {
    if (nextVideoId)
        router.push({ name: 'videos/id', params: { id: nextVideoId } })
    else
        // 마지막 영상이면 첫 번째 영상으로 이동
        router.push({ name: 'videos/id', params: { id: videos[0].id } })
}

// 이전 영상 버튼
// 첫 번째 영상이면 prevVideoId가 null이므로 아무것도 하지 않음
const playPrev = () => {
    if (prevVideoId)
        router.push({ name: 'videos/id', params: { id: prevVideoId } })
}

// /videos/1 → /videos/2 처럼 파라미터만 바뀔 때 실행
// 같은 컴포넌트가 재사용되므로 새로 마운트되지 않아
// onBeforeRouteUpdate로 파라미터 변경을 감지해서 영상 정보를 직접 갱신해야 함
onBeforeRouteUpdate((to) => {
    getNavId(to)
})

// 현재 경로에서 벗어날 때 실행됨
// 예: 작성 중인 내용이 있을 때 페이지 이동을 막는 용도로 활용
onBeforeRouteLeave((to, from) => {
    const answer = window.confirm('페이지를 떠나시겠습니까?')
    if (!answer) return false  // 이동 취소
})
</script>

<style scoped>
.modal {
    display: block;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
}

.box {
    background-color: white;
    margin: 80px auto;
    max-width: 500px;
    min-width: 100px;
    min-height: 350px;
    font: 13px "verdana";
    padding: 10px 10px 10px 10px;
}

.box div {
    padding: 0;
    display: block;
    margin: 10px 0 0 0;
}

.box .heading {
    background: #33A17F;
    font-weight: 300;
    text-align: left;
    color: #fff;
    margin: 5px 0 5px 0;
    padding: 10px;
    min-width: 200px;
    max-width: 500px;
}

.box .player {
    background: white;
}

.pointer {
    cursor: pointer;
}
</style>

<!-- 
========================================
Router 중심 구조
========================================

특징
→ URL(param)이 기준이 되는 구조

예
/videos/1 → /videos/2

router.push() 로 URL이 변경되면
onBeforeRouteUpdate() 가 실행되어
영상 정보를 다시 계산한다.

즉

router.push()
↓
URL 변경
↓
route param 변경 감지
↓
영상 데이터 업데이트


*/
-->