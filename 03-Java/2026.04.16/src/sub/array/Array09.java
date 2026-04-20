package com.kb.d_chap05.s;

import java.util.Arrays;

/*
 * ===============================
 * Array09 - 다차원 배열
 * ===============================
 *
 * 다차원 배열이란?
 * - 배열의 배열 구조이다
 * - 2차원 배열은 표(행과 열)처럼 데이터를 관리할 때 사용한다
 * - 실무에서는 2차원 배열까지 주로 사용한다
 *
 * 2차원 배열 선언
 * 자료형[][] 변수명 = new 자료형[행의수][열의수];
 */
public class Array09 {
    public static void main(String[] args) {

        // ===============================
        // 1. 2차원 배열 생성 과정 (4단계)
        // ===============================

        // 1단계 : 참조 변수 선언 (Stack)
        int[][] arr;

        // 2단계 : 행 배열 생성 (Heap - 행의 수만 결정)
        arr = new int[3][];
        /*
         * Heap
         * arr[0] = null
         * arr[1] = null
         * arr[2] = null
         */

        // 3단계 : 각 행에 1차원 배열 할당
        arr[0] = new int[5];
        arr[1] = new int[5];
        arr[2] = new int[5];
        /*
         * Heap
         * arr[0] → [0, 0, 0, 0, 0]
         * arr[1] → [0, 0, 0, 0, 0]
         * arr[2] → [0, 0, 0, 0, 0]
         */

        // 4단계 : 값 저장
        arr[0][0] = 10;
        arr[1][2] = 99;
        arr[2][4] = 7;

        System.out.println("행의 길이 : " + arr.length);
        System.out.println("열의 길이 : " + arr[0].length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        // ===============================
        // 2. 값 목록으로 2차원 배열 생성 (정변 배열)
        // ===============================
        /*
         * 정변 배열 : 모든 행의 열 수가 동일한 배열
         */
        int[][] scores = {
                {80, 90, 96},
                {76, 88, 92}
        };

        System.out.println("\n1차원 배열 길이(반의 수) : " + scores.length);
        System.out.println("1반 학생 수 : " + scores[0].length);
        System.out.println("2반 학생 수 : " + scores[1].length);
        System.out.println("1반 3번째 학생 점수 : " + scores[0][2]);
        System.out.println("2반 2번째 학생 점수 : " + scores[1][1]);

        // 1반 평균
        int class1Sum = 0;
        for (int i = 0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        System.out.println("1반 평균 : " + (double) class1Sum / scores[0].length);

        // 전체 평균
        int totalStudent = 0;
        int totalSum = 0;
        for (int[] score : scores) {         // 각 반을 순회
            totalStudent += score.length;    // 반의 학생 수 합산
            for (int s : score) {            // 각 학생 점수 합산
                totalSum += s;
            }
        }
        System.out.println("전체 평균 : " + (double) totalSum / totalStudent);


        // ===============================
        // 3. new 연산자로 2차원 배열 생성 (정변 배열)
        // ===============================
        int[][] mathScores = new int[2][3]; // 2반, 반당 3명

        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;

        System.out.println("\n수학 전체 배열 : " + Arrays.deepToString(mathScores));


        // ===============================
        // 4. 가변 배열 (행마다 열의 수가 다름)
        // ===============================
        /*
         * 가변 배열 : 각 행의 열 수가 다를 수 있는 배열
         * 행의 수만 먼저 정하고, 각 행의 크기를 따로 지정한다
         */
        int[][] englishScores = new int[2][]; // 행의 수만 지정
        englishScores[0] = new int[2];        // 1반 학생 2명
        englishScores[1] = new int[3];        // 2반 학생 3명

        englishScores[0][0] = 90;
        englishScores[0][1] = 91;
        englishScores[1][0] = 92;
        englishScores[1][1] = 93;
        englishScores[1][2] = 94;

        System.out.println("\n영어 가변 배열 : " + Arrays.deepToString(englishScores));

        // 가변 배열도 동일하게 for-each으로 처리 가능
        int engTotal = 0;
        int engStudent = 0;
        for (int[] row : englishScores) {
            engStudent += row.length;
            for (int score : row) {
                engTotal += score;
            }
        }
        System.out.println("영어 전체 평균 : " + (double) engTotal / engStudent);


        // ===============================
        // 5. 2차원 배열 출력 - Arrays.deepToString()
        // ===============================
        /*
         * Arrays.toString()     : 1차원 배열 출력
         * Arrays.deepToString() : 다차원 배열 출력
         */
        int[][] fixedArr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println("\n2차원 배열 출력 : " + Arrays.deepToString(fixedArr));
    }
}
