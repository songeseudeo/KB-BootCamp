package com.multi.d_etc;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * ===============================
 * Exec06 - 날짜와 시간 API
 * ===============================
 *
 * Java 의 날짜/시간 API 는 세 가지 세대로 나뉜다
 *
 * 1세대 : Date (JDK 1.0)         - 레거시. 사용 비권장
 * 2세대 : Calendar (JDK 1.1)     - 레거시. 사용 비권장
 * 3세대 : java.time (JDK 1.8+)   - 현재 표준.
 *
 * 참고 : https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
 */
public class Exec06v2 {

	public static void main(String[] args) {

		// ===============================
		// 1. Date (레거시 - 사용 비권장)
		// ===============================
		/*
		 * JDK 1.0 부터 존재한 날짜 클래스
		 * 1970년 1월 1일 00:00:00 (UTC) 기준으로 milliseconds 단위로 시간을 계산한다
		 *
		 * UTC(Coordinated Universal Time) 란?
		 * - 전 세계가 공통으로 쓰는 기준 시계이다
		 * - 한국(KST) = UTC + 9시간
		 * - 미국 뉴욕 = UTC - 5시간
		 * - 영국(GMT) = UTC + 0시간
		 *
		 * 사용 비권장 이유
		 * - 연도는 +1900, 월은 +1 보정이 필요해서 실수하기 쉽다
		 * - 많은 메소드가 Deprecated 처리되어 있다
		 * - Thread-safe 하지 않다 (가변 객체)
		 * - 다국적 환경에서 사용하기 적합하지 않다
		 */

		// 현재 시각
		Date today = new Date();
		System.out.println("현재 시각 : " + today);

		// 특정 날짜 생성 - 연도는 -1900, 월은 -1 을 입력해야 한다
		// 예) 2020년 1월 28일 → new Date(120, 0, 28)
		// @Deprecated - Calendar.set(year + 1900, month, date) 사용 권장
		Date today1 = new Date(120, 0, 28);
		System.out.println("특정 날짜 : " + today1);

		// 원하는 패턴으로 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");
		System.out.println("포맷 출력 : " + sdf.format(today1));

		// 날짜 정보 추출 - 메소드 대부분 Deprecated
		System.out.println("날짜 : " + today.getDate());
		System.out.println("요일 : " + today.getDay());
		System.out.println("시 : "   + today.getHours());
		System.out.println("분 : "   + today.getMinutes());
		System.out.println("달 : "   + (today.getMonth() + 1));   // 주의 : +1 필요
		System.out.println("초 : "   + today.getSeconds());
		System.out.println("년 : "   + (today.getYear() + 1900)); // 주의 : +1900 필요

		// 현재 시각을 문자열로 변환하는 패턴 (실무에서 자주 쓰는 형태)
		String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println("현재시각(문자열) : " + curTime);


		System.out.println("------------ Calendar -------------");
		// ===============================
		// 2. Calendar (레거시 - 사용 비권장)
		// ===============================
		/*
		 * JDK 1.1 부터 제공
		 * Date 의 단점을 보완했지만 여전히 월(month) 이 0부터 시작한다
		 *
		 * 사용 비권장 이유
		 * - 월이 0부터 시작해서 실수하기 쉽다
		 * - 가변 객체(mutable) 라 Thread-safe 하지 않다
		 *
		 * getInstance() 를 사용하는 이유
		 * - 기본 생성자가 protected 라 new Calendar() 로 생성 불가
		 * - 내부적으로는 GregorianCalendar 를 반환한다
		 * - 나중에 다른 캘린더 시스템으로 교체할 때 getInstance() 부분만
		 *   수정하면 되므로 결합도를 낮출 수 있다
		 */

		Calendar calendar = Calendar.getInstance(); // 현재 시각

		// 특정 날짜 설정 - 연도는 그대로, 월은 -1 입력
		calendar.set(2008, 2 - 1, 29); // 2008년 2월 29일

		System.out.println("날짜 : " + calendar.get(Calendar.DATE));
		System.out.println("요일 : " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("시 : "   + calendar.get(Calendar.HOUR));
		System.out.println("분 : "   + calendar.get(Calendar.MINUTE));
		System.out.println("달 : "   + (calendar.get(Calendar.MONTH) + 1)); // 주의 : +1 필요
		System.out.println("초 : "   + calendar.get(Calendar.SECOND));
		System.out.println("년 : "   + calendar.get(Calendar.YEAR));

		// 원하는 포맷으로 출력
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd E요일 hh:mm:ss a");
		System.out.println("포맷 출력 : " + sdf1.format(calendar.getTime()));


		System.out.println("------------ GregorianCalendar -------------");
		// ===============================
		// 3. GregorianCalendar
		// ===============================
		/*
		 * Calendar 의 구현체 (후손 클래스)
		 * 율리우스력의 오차를 수정한 그레고리력을 기반으로 한다
		 *
		 * 윤년 계산 규칙
		 * - 4의 배수이면서 100의 배수가 아닌 해 → 윤년 (예: 2008년)
		 * - 100의 배수이면서 400의 배수가 아닌 해 → 평년 (예: 2300년)
		 * - 400의 배수인 해 → 윤년 (예: 2400년)
		 */

		GregorianCalendar gc = new GregorianCalendar(); // 현재 시각

		System.out.println("날짜 : " + gc.get(GregorianCalendar.DATE));
		System.out.println("요일 : " + gc.get(GregorianCalendar.DAY_OF_WEEK));
		System.out.println("달 : "   + (gc.get(GregorianCalendar.MONTH) + 1)); // 주의 : +1 필요
		System.out.println("년 : "   + gc.get(GregorianCalendar.YEAR));

		gc.set(2008, 2 - 1, 29); // 2008년 2월 29일 (윤년)
		System.out.println("설정 날짜 : " + gc.getTime());


		System.out.println("------------ java.time (현재 표준) -------------");
		// ===============================
		// 4. java.time (JDK 1.8+ - 현재 표준)
		// ===============================
		/*
		 * Java 8 부터 도입된 현대적 날짜/시간 API
		 *
		 * 특징
		 * - 불변 객체 (Immutable) → Thread-safe
		 * - 월(month) 이 1부터 시작 → 실수 없음
		 * - 날짜 / 시간 / 시간대 개념을 분리해서 명확하다
		 * - ISO-8601 국제 표준을 따른다
		 *
		 * 주요 클래스
		 * - LocalDate       : 날짜만 (시간 없음)          예) 2024-01-28
		 * - LocalTime       : 시간만 (날짜 없음)          예) 10:15:30
		 * - LocalDateTime   : 날짜 + 시간 (시간대 없음)   예) 2024-01-28T10:15:30
		 * - ZonedDateTime   : 날짜 + 시간 + 시간대        예) 2024-01-28T10:15:30+09:00[Asia/Seoul]
		 * - Instant         : UTC 기준 절대 시간 (타임스탬프)
		 * - Duration        : 시간 기반 경과량             예) 34.5초
		 * - Period          : 날짜 기반 경과량             예) 2년 3개월 4일
		 */

		// 현재 날짜 / 시간
		LocalDate today3    = LocalDate.now();
		LocalTime nowTime   = LocalTime.now();
		LocalDateTime now   = LocalDateTime.now();

		System.out.println("오늘 날짜 : "   + today3);
		System.out.println("현재 시간 : "   + nowTime);
		System.out.println("날짜 + 시간 : " + now);

		// 특정 날짜 생성 - 월이 1부터 시작하므로 보정 불필요
		LocalDate customDate = LocalDate.of(2020, 1, 28);
		System.out.println("지정 날짜 : " + customDate);

		// 포맷팅
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("yyyy/MM/dd E요일 HH:mm:ss");
		System.out.println("포맷 출력 : " + now.format(formatter));

		// 윤년 여부 확인
		boolean leap2008 = Year.of(2008).isLeap();
		boolean leap2300 = Year.of(2300).isLeap();
		boolean leap2400 = Year.of(2400).isLeap();
		System.out.println("2008년 윤년? " + leap2008); // true
		System.out.println("2300년 윤년? " + leap2300); // false
		System.out.println("2400년 윤년? " + leap2400); // true


		System.out.println("------------ 시간대 (ZonedDateTime) -------------");
		// ===============================
		// 5. 시간대 (ZonedDateTime)
		// ===============================
		/*
		 * 국가 / 지역마다 시간대(Time Zone) 가 다르다
		 * ZonedDateTime 을 사용하면 시간대까지 포함해서 관리할 수 있다
		 * 시간대가 필요 없는 경우에는 LocalDateTime 을 사용하는 것이 더 간단하다
		 */

		ZonedDateTime seoul   = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		ZonedDateTime newYork = ZonedDateTime.now(ZoneId.of("America/New_York"));

		System.out.println("서울 시간 : " + seoul);
		System.out.println("뉴욕 시간 : " + newYork);


		System.out.println("------------ Instant -------------");
		// ===============================
		// 6. Instant (절대 시간)
		// ===============================
		/*
		 * 시간 축(Time-line) 상의 한 순간을 나타낸다
		 * 항상 UTC 기준이며 날짜 개념이 없다
		 *
		 * UTC(Coordinated Universal Time) 란?
		 * - 전 세계가 공통으로 쓰는 기준 시계이다
		 * - 모든 나라의 시간은 UTC 를 기준으로 +/- 로 표현한다
		 *
		 *   UTC 기준 시각 : 2024-01-28 01:00:00
		 *   한국(KST)     : UTC + 9시간 → 2024-01-28 10:00:00
		 *   미국 뉴욕     : UTC - 5시간 → 2024-01-27 20:00:00
		 *   영국(GMT)     : UTC + 0시간 → 2024-01-28 01:00:00
		 *
		 * DB 에 UTC 로 저장하는 이유
		 * - 한국 시간으로 저장하면 서버를 다른 나라로 이전했을 때 시간이 틀어진다
		 * - UTC 로 저장하면 어느 나라 서버에서 읽어도 올바른 현지 시간으로 변환된다
		 *
		 *   잘못된 방식 : DB 저장값 2024-01-28 10:00:00 (KST)
		 *               → 미국 서버에서 읽으면 2024-01-27 20:00:00 (EST) 로 해석 → 시간 틀어짐
		 *
		 *   올바른 방식 : DB 저장값 2024-01-28 01:00:00 (UTC)
		 *               → 한국 서버 : UTC + 9  → 2024-01-28 10:00:00
		 *               → 미국 서버 : UTC - 5  → 2024-01-27 20:00:00
		 *               → 항상 올바른 현지 시간으로 변환된다
		 *
		 * 사용 목적
		 * - 서버 로그 시간 기록
		 * - 이벤트 발생 시점 기록
		 * - DB timestamp 저장
		 * - 두 시점 사이의 경과 시간 계산
		 *
		 * Date 의 대체 클래스이다
		 */

		Instant instantNow = Instant.now();
		System.out.println("현재 Instant (UTC) : "  + instantNow);
		System.out.println("Epoch milliseconds : "  + instantNow.toEpochMilli());
		System.out.println("Epoch seconds : "       + instantNow.getEpochSecond());

		// Instant → LocalDateTime 변환 (한국 시간으로)
		// DB 에서 UTC 로 읽어온 뒤 사용자에게 보여줄 때 현지 시간으로 변환하는 실무 패턴
		LocalDateTime instantToKorea =
				LocalDateTime.ofInstant(instantNow, ZoneId.of("Asia/Seoul"));
		System.out.println("Instant → 한국 시간 : " + instantToKorea);

		// LocalDateTime → Instant 변환
		// 사용자 입력값을 DB 에 UTC 로 저장하기 전 변환하는 실무 패턴
		Instant koreaToInstant =
				instantToKorea.atZone(ZoneId.of("Asia/Seoul")).toInstant();
		System.out.println("한국 시간 → Instant : " + koreaToInstant);


		System.out.println("------------ Duration / Period -------------");
		// ===============================
		// 7. Duration / Period (경과 시간)
		// ===============================
		/*
		 * Duration : 시간 기반 경과량 (초, 밀리초, 나노초 단위)
		 *            예) 두 시점 사이의 경과 시간
		 *
		 * Period   : 날짜 기반 경과량 (년, 월, 일 단위)
		 *            예) 두 날짜 사이의 차이
		 */

		// Duration - 경과 시간 측정
		Instant start = Instant.now();

		try {
			Thread.sleep(500); // 0.5초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);

		System.out.println("경과 시간(ms) : " + duration.toMillis());
		System.out.println("경과 시간(ns) : " + duration.toNanos());

		// Period - 두 날짜 사이의 차이
		LocalDate startDate = LocalDate.of(2020, 1, 1);
		LocalDate endDate   = LocalDate.of(2024, 4, 16);
		Period period       = Period.between(startDate, endDate);

		System.out.println("경과 : " + period.getYears()  + "년 "
				+ period.getMonths() + "개월 "
				+ period.getDays()   + "일");


		// ===============================
		// 실무에서 계층별 권장 타입
		// ===============================
		/*
		 * DB / Entity    → Instant 또는 OffsetDateTime (UTC 기준 저장 권장)
		 * Service 내부   → LocalDate, LocalTime, LocalDateTime (시간대 불필요 시)
		 *                  ZonedDateTime (시간대 필요 시)
		 * DTO / API 응답 → OffsetDateTime 또는 LocalDateTime (용도에 따라)
		 * UI             → 문자열 (yyyy-MM-dd HH:mm:ss)
		 *
		 * 핵심 원칙
		 * - DB 에는 UTC 로 저장한다
		 * - 사용자에게 보여줄 때만 현지 시간으로 변환한다
		 */
	}
}