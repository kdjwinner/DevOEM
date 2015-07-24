package com.ktf.oem.data;

public class XringInfo {

	/** TB_FILE_INFO�� ����� ��ȣ **/
	private String fileCode = null;
	/** XRing �ڵ� **/
	private String xRingCode = null;		
	// ��ȭ�۾� �߰� 
	
	/** MetaSeq  **/
	private int Metaseq = 0;

	/** LID  **/
	private int lid = 0;

	/** ����  **/
	private int sec = 0;

	/** STATE  **/
	private String state = null;

	/** �ٹ�ID  **/
	private String album_id = null;

	/** STATE  **/
	private int bellid = 0;
	
	/** XRing1 �ڵ� **/
	private String xRingCode1 = null;
	/** XRing2 �ڵ� **/
	private String xRingCode2 = null;
	/** XRing3 �ڵ� **/
	private String xRingCode3 = null;
	
	/** LRing1 �ڵ� **/
	private String lRingCode1 = null;
	/** LRing2 �ڵ� **/
	private String lRingCode2 = null;
	/** LRing3 �ڵ� **/
	private String lRingCode3 = null;
	
	/** ���� **/
	private String title = null;
	/** ������ **/
	private String singer = null;
	/** �ٹ��� 2006.11.06 �߰�**/
	private String album = null;
	/** ���� **/
	private String words = null;

	/** �����(YYYY-MM-DD) **/
	private String regDate = null;

	/** ������ü ID **/
	private String scpID = null;
	/** ������ü�� **/
	private String scpName = null;
	/** ������ü���񽺸� **/
	private String svcName = null;

	/** Wavȭ�ϸ� **/
	private String wavFile = null;
	/** asfȭ�ϸ� **/
	private String asfFile = null;
	/** infȭ�ϸ� **/
	private String infFile = null;
	/** ma3ȭ�ϸ� **/
	private String ma3File = null;
	/** ma5ȭ�ϸ� **/
	private String ma5File = null;
	
	/** KTF ī�װ� �ڵ� **/
	private String ktfCateCode = null;
	/** KTF ī�װ��� **/
	private String ktfCateName = null;
	/** THEME ī�װ� �ڵ� **/
	private String themeCateCode = null;
	/** THEME ī�װ��� **/
	private String themeCateName = null;
	/** SCP ī�װ� �ڵ� **/
	private String scpCateCode = null;
	/** SCP ī�װ��� **/
	private String scpCateName = null;
	/** subCP ī�װ� �ڵ� **/
	private String subcpCateCode = null;
	/** subCP ī�װ��� **/
	private String subcpCateName = null; 
	
	/** ��������Ƚ�� **/
	private int fileCount = 0;

	/** Mp3Ring�� ��� ���� **/
	private Mp3RingInfo mp3Ring = null;

	/** IntroRing�� ��� ���� **/
	private IntroRingInfo introRing = null;
	
	/** ��ũüũ 0:���Ұ���, 1:��Ⱑ�� **/
	private String jukechk = null;	
	
	// ��ȭ�۾� �߰� 
	/** ��ũüũ1 0:���Ұ���, 1:��Ⱑ�� **/
	private String jukechk1 = null;
	/** ��ũüũ2 0:���Ұ���, 1:��Ⱑ�� **/
	private String jukechk2 = null;
	/** ��ũüũ3 0:���Ұ���, 1:��Ⱑ�� **/
	private String jukechk3 = null;
	
	// ��û�� ��� ���� �߰� ����
	/** ��û�� ��� ���� ��û���̸� **/
	private String nickname = null;
	/** ��û�� ��� ���� ��û�� **/
	private String applydate = null;
	/** ��û�� ��� ���� ��û���� **/
	private String resultstate = null;
	/** ��û�� ��� ���� ��ûseqnum **/
	private int seqnum = 0;
	/** ��û�� ��� ���� phonenum **/
	private String phonenum = null;
	/** ��û�� ��� ���� content **/
	private String content = null;
	/** ��û�� ��� ���� ���� ī��Ʈ **/
	private int sub_count = 0;
	/** 19�� ����**/
	private String R19_LICENCE_TF = null;
	
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getxRingCode() {
		return xRingCode;
	}
	public void setxRingCode(String xRingCode) {
		this.xRingCode = xRingCode;
	}
	public int getMetaseq() {
		return Metaseq;
	}
	public void setMetaseq(int metaseq) {
		Metaseq = metaseq;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}
	public int getBellid() {
		return bellid;
	}
	public void setBellid(int bellid) {
		this.bellid = bellid;
	}
	public String getxRingCode1() {
		return xRingCode1;
	}
	public void setxRingCode1(String xRingCode1) {
		this.xRingCode1 = xRingCode1;
	}
	public String getxRingCode2() {
		return xRingCode2;
	}
	public void setxRingCode2(String xRingCode2) {
		this.xRingCode2 = xRingCode2;
	}
	public String getxRingCode3() {
		return xRingCode3;
	}
	public void setxRingCode3(String xRingCode3) {
		this.xRingCode3 = xRingCode3;
	}
	public String getlRingCode1() {
		return lRingCode1;
	}
	public void setlRingCode1(String lRingCode1) {
		this.lRingCode1 = lRingCode1;
	}
	public String getlRingCode2() {
		return lRingCode2;
	}
	public void setlRingCode2(String lRingCode2) {
		this.lRingCode2 = lRingCode2;
	}
	public String getlRingCode3() {
		return lRingCode3;
	}
	public void setlRingCode3(String lRingCode3) {
		this.lRingCode3 = lRingCode3;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getScpID() {
		return scpID;
	}
	public void setScpID(String scpID) {
		this.scpID = scpID;
	}
	public String getScpName() {
		return scpName;
	}
	public void setScpName(String scpName) {
		this.scpName = scpName;
	}
	public String getSvcName() {
		return svcName;
	}
	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}
	public String getWavFile() {
		return wavFile;
	}
	public void setWavFile(String wavFile) {
		this.wavFile = wavFile;
	}
	public String getAsfFile() {
		return asfFile;
	}
	public void setAsfFile(String asfFile) {
		this.asfFile = asfFile;
	}
	public String getInfFile() {
		return infFile;
	}
	public void setInfFile(String infFile) {
		this.infFile = infFile;
	}
	public String getMa3File() {
		return ma3File;
	}
	public void setMa3File(String ma3File) {
		this.ma3File = ma3File;
	}
	public String getMa5File() {
		return ma5File;
	}
	public void setMa5File(String ma5File) {
		this.ma5File = ma5File;
	}
	public String getKtfCateCode() {
		return ktfCateCode;
	}
	public void setKtfCateCode(String ktfCateCode) {
		this.ktfCateCode = ktfCateCode;
	}
	public String getKtfCateName() {
		return ktfCateName;
	}
	public void setKtfCateName(String ktfCateName) {
		this.ktfCateName = ktfCateName;
	}
	public String getThemeCateCode() {
		return themeCateCode;
	}
	public void setThemeCateCode(String themeCateCode) {
		this.themeCateCode = themeCateCode;
	}
	public String getThemeCateName() {
		return themeCateName;
	}
	public void setThemeCateName(String themeCateName) {
		this.themeCateName = themeCateName;
	}
	public String getScpCateCode() {
		return scpCateCode;
	}
	public void setScpCateCode(String scpCateCode) {
		this.scpCateCode = scpCateCode;
	}
	public String getScpCateName() {
		return scpCateName;
	}
	public void setScpCateName(String scpCateName) {
		this.scpCateName = scpCateName;
	}
	public String getSubcpCateCode() {
		return subcpCateCode;
	}
	public void setSubcpCateCode(String subcpCateCode) {
		this.subcpCateCode = subcpCateCode;
	}
	public String getSubcpCateName() {
		return subcpCateName;
	}
	public void setSubcpCateName(String subcpCateName) {
		this.subcpCateName = subcpCateName;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	public Mp3RingInfo getMp3Ring() {
		return mp3Ring;
	}
	public void setMp3Ring(Mp3RingInfo mp3Ring) {
		this.mp3Ring = mp3Ring;
	}
	public IntroRingInfo getIntroRing() {
		return introRing;
	}
	public void setIntroRing(IntroRingInfo introRing) {
		this.introRing = introRing;
	}
	public String getJukechk() {
		return jukechk;
	}
	public void setJukechk(String jukechk) {
		this.jukechk = jukechk;
	}
	public String getJukechk1() {
		return jukechk1;
	}
	public void setJukechk1(String jukechk1) {
		this.jukechk1 = jukechk1;
	}
	public String getJukechk2() {
		return jukechk2;
	}
	public void setJukechk2(String jukechk2) {
		this.jukechk2 = jukechk2;
	}
	public String getJukechk3() {
		return jukechk3;
	}
	public void setJukechk3(String jukechk3) {
		this.jukechk3 = jukechk3;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getResultstate() {
		return resultstate;
	}
	public void setResultstate(String resultstate) {
		this.resultstate = resultstate;
	}
	public int getSeqnum() {
		return seqnum;
	}
	public void setSeqnum(int seqnum) {
		this.seqnum = seqnum;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSub_count() {
		return sub_count;
	}
	public void setSub_count(int sub_count) {
		this.sub_count = sub_count;
	}
	public String getR19_LICENCE_TF() {
		return R19_LICENCE_TF;
	}
	public void setR19_LICENCE_TF(String r19_LICENCE_TF) {
		R19_LICENCE_TF = r19_LICENCE_TF;
	}
	
}
