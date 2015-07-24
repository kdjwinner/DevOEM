package com.ktf.oem.data;

public class IntroRingInfo{
	/** TB_INTRORING_INFO에 저장된 등록날짜 **/
	private String measure_date = null;

	/** TB_INTRORING_INFO에 저장된 설정 폰 번호 **/
	private String min = null;

	/** TB_INTRORING_INFO에 저장된 과금 폰 번호 **/
	private String c_min = null;

	/** TB_INTRORING_INFO에 저장된 제목 **/
	private String title = null;

	/** TB_INTRORING_INFO에 저장된 SysType (1:Web, 2:Me) **/
	private char sys_type = ' ';

	/** TB_INTRORING_INFO에 저장된 XRing 코드 **/
	private String xRingCode = null;

	/** TB_INTRORING_INFO에 저장된 음원의 업로드 상태 (0:상태, 2:승인요청, 4:진행중일때 페이지엔 승인대기로 출력, 1:완전한 승인이 남, 3:5번 재시도 후 완전 실패로 페이지에 실패로 출력, 5:미리승인, 6:파일없음, 9: **/
	private char state = ' ';

	/** TB_INTRORING_INFO에 저장된 삭제 상태 (0:삭제, 1:사용) **/
	private char del_state = ' ';

	/** TB_INTRORING_INFO에 저장된 유선 미리듣기 URL */
	private String web_prelisten = null;
	
	/** TB_INTRORING_INFO에 저장된 무선 미리듣기 URL */
	private String me_prelisten = null;
}