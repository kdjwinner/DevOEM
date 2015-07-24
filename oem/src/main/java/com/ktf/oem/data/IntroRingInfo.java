package com.ktf.oem.data;

public class IntroRingInfo{
	/** TB_INTRORING_INFO�� ����� ��ϳ�¥ **/
	private String measure_date = null;

	/** TB_INTRORING_INFO�� ����� ���� �� ��ȣ **/
	private String min = null;

	/** TB_INTRORING_INFO�� ����� ���� �� ��ȣ **/
	private String c_min = null;

	/** TB_INTRORING_INFO�� ����� ���� **/
	private String title = null;

	/** TB_INTRORING_INFO�� ����� SysType (1:Web, 2:Me) **/
	private char sys_type = ' ';

	/** TB_INTRORING_INFO�� ����� XRing �ڵ� **/
	private String xRingCode = null;

	/** TB_INTRORING_INFO�� ����� ������ ���ε� ���� (0:����, 2:���ο�û, 4:�������϶� �������� ���δ��� ���, 1:������ ������ ��, 3:5�� ��õ� �� ���� ���з� �������� ���з� ���, 5:�̸�����, 6:���Ͼ���, 9: **/
	private char state = ' ';

	/** TB_INTRORING_INFO�� ����� ���� ���� (0:����, 1:���) **/
	private char del_state = ' ';

	/** TB_INTRORING_INFO�� ����� ���� �̸���� URL */
	private String web_prelisten = null;
	
	/** TB_INTRORING_INFO�� ����� ���� �̸���� URL */
	private String me_prelisten = null;
}