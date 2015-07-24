package com.ktf.oem.data;

public class XringInfo {

	/** TB_FILE_INFO에 저장된 번호 **/
	private String fileCode = null;
	/** XRing 코드 **/
	private String xRingCode = null;		
	// 고도화작업 추가 
	
	/** MetaSeq  **/
	private int Metaseq = 0;

	/** LID  **/
	private int lid = 0;

	/** 구간  **/
	private int sec = 0;

	/** STATE  **/
	private String state = null;

	/** 앨범ID  **/
	private String album_id = null;

	/** STATE  **/
	private int bellid = 0;
	
	/** XRing1 코드 **/
	private String xRingCode1 = null;
	/** XRing2 코드 **/
	private String xRingCode2 = null;
	/** XRing3 코드 **/
	private String xRingCode3 = null;
	
	/** LRing1 코드 **/
	private String lRingCode1 = null;
	/** LRing2 코드 **/
	private String lRingCode2 = null;
	/** LRing3 코드 **/
	private String lRingCode3 = null;
	
	/** 제목 **/
	private String title = null;
	/** 가수명 **/
	private String singer = null;
	/** 앨범명 2006.11.06 추가**/
	private String album = null;
	/** 가사 **/
	private String words = null;

	/** 등록일(YYYY-MM-DD) **/
	private String regDate = null;

	/** 제공업체 ID **/
	private String scpID = null;
	/** 제공업체명 **/
	private String scpName = null;
	/** 제공업체서비스명 **/
	private String svcName = null;

	/** Wav화일명 **/
	private String wavFile = null;
	/** asf화일명 **/
	private String asfFile = null;
	/** inf화일명 **/
	private String infFile = null;
	/** ma3화일명 **/
	private String ma3File = null;
	/** ma5화일명 **/
	private String ma5File = null;
	
	/** KTF 카테고리 코드 **/
	private String ktfCateCode = null;
	/** KTF 카테고리명 **/
	private String ktfCateName = null;
	/** THEME 카테고리 코드 **/
	private String themeCateCode = null;
	/** THEME 카테고리명 **/
	private String themeCateName = null;
	/** SCP 카테고리 코드 **/
	private String scpCateCode = null;
	/** SCP 카테고리명 **/
	private String scpCateName = null;
	/** subCP 카테고리 코드 **/
	private String subcpCateCode = null;
	/** subCP 카테고리명 **/
	private String subcpCateName = null; 
	
	/** 음원설정횟수 **/
	private int fileCount = 0;

	/** Mp3Ring일 경우 설정 **/
	private Mp3RingInfo mp3Ring = null;

	/** IntroRing일 경우 설정 **/
	private IntroRingInfo introRing = null;
	
	/** 쥬크체크 0:담기불가능, 1:담기가능 **/
	private String jukechk = null;	
	
	// 고도화작업 추가 
	/** 쥬크체크1 0:담기불가능, 1:담기가능 **/
	private String jukechk1 = null;
	/** 쥬크체크2 0:담기불가능, 1:담기가능 **/
	private String jukechk2 = null;
	/** 쥬크체크3 0:담기불가능, 1:담기가능 **/
	private String jukechk3 = null;
	
	// 신청곡 배달 서비스 추가 변수
	/** 신청곡 배달 서비스 신청자이름 **/
	private String nickname = null;
	/** 신청곡 배달 서비스 신청일 **/
	private String applydate = null;
	/** 신청곡 배달 서비스 신청상태 **/
	private String resultstate = null;
	/** 신청곡 배달 서비스 신청seqnum **/
	private int seqnum = 0;
	/** 신청곡 배달 서비스 phonenum **/
	private String phonenum = null;
	/** 신청곡 배달 서비스 content **/
	private String content = null;
	/** 신청곡 배달 서비스 덧글 카운트 **/
	private int sub_count = 0;
	/** 19금 정보**/
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
