package model;

public class MeminfoVo {
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String gender;
	private String tel;
	private String email;
	private String sido;
	private String sigungu;
	private String eup_myeon_dong;
	private String li;
	private String doro;
	private String doro_bon;
	private String doro_bu;
	private String sigungu_build_name;
	private String build_detail;
	private String address_detail;
	
	
	
	public MeminfoVo(String id, String pw, String name, String birth, String gender, String tel, String email,
			String sido, String sigungu, String eup_myeon_dong, String li, String doro, String doro_bon, String doro_bu,
			String sigungu_build_name, String build_detail, String address_detail) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.tel = tel;
		this.email = email;
		this.sido = sido;
		this.sigungu = sigungu;
		this.eup_myeon_dong = eup_myeon_dong;
		this.li = li;
		this.doro = doro;
		this.doro_bon = doro_bon;
		this.doro_bu = doro_bu;
		this.sigungu_build_name = sigungu_build_name;
		this.build_detail = build_detail;
		this.address_detail = address_detail;
	}



	public MeminfoVo(String id2, String pw2, String name2, String birth2, String gender2, String tel2, String email2,
			SearchDoroVo sDoroVo, String address_detail) {
		this.id = id2;
		this.pw = pw2;
		this.name = name2;
		this.birth = birth2;
		this.gender = gender2;
		this.tel = tel2;
		this.email = email2;
		this.sido = sDoroVo.getSido();
		this.sigungu = sDoroVo.getSigungu();
		this.eup_myeon_dong = sDoroVo.getEup_myeon_dong();
		this.li = sDoroVo.getLi();
		this.doro = sDoroVo.getDoro();
		this.doro_bon = sDoroVo.getDoro_bon();
		this.doro_bu = sDoroVo.getDoro_bu();
		this.sigungu_build_name = sDoroVo.getSigungu_build_name();
		this.build_detail = sDoroVo.getBuild_detail();
		this.address_detail = address_detail;
	}

	public SearchDoroVo meminfoVoToSearchDoroVo(MeminfoVo meminfoVo) {
		SearchDoroVo sDoroVo = new SearchDoroVo(sido, sigungu, eup_myeon_dong, li, doro, doro_bon, doro_bu, sigungu_build_name, build_detail);
		return sDoroVo;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSido() {
		return sido;
	}



	public void setSido(String sido) {
		this.sido = sido;
	}



	public String getSigungu() {
		return sigungu;
	}



	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}



	public String getEup_myeon_dong() {
		return eup_myeon_dong;
	}



	public void setEup_myeon_dong(String eup_myeon_dong) {
		this.eup_myeon_dong = eup_myeon_dong;
	}



	public String getLi() {
		return li;
	}



	public void setLi(String li) {
		this.li = li;
	}



	public String getDoro() {
		return doro;
	}



	public void setDoro(String doro) {
		this.doro = doro;
	}



	public String getDoro_bon() {
		return doro_bon;
	}



	public void setDoro_bon(String doro_bon) {
		this.doro_bon = doro_bon;
	}



	public String getDoro_bu() {
		return doro_bu;
	}



	public void setDoro_bu(String doro_bu) {
		this.doro_bu = doro_bu;
	}



	public String getSigungu_build_name() {
		return sigungu_build_name;
	}



	public void setSigungu_build_name(String sigungu_build_name) {
		this.sigungu_build_name = sigungu_build_name;
	}



	public String getBuild_detail() {
		return build_detail;
	}



	public void setBuild_detail(String build_detail) {
		this.build_detail = build_detail;
	}



	public String getAddress_detail() {
		return address_detail;
	}



	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}



	@Override
	public String toString() {
		return "MeminfoVo [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", gender=" + gender
				+ ", tel=" + tel + ", email=" + email + ", sido=" + sido + ", sigungu=" + sigungu + ", eup_myeon_dong="
				+ eup_myeon_dong + ", li=" + li + ", doro=" + doro + ", doro_bon=" + doro_bon + ", doro_bu=" + doro_bu
				+ ", sigungu_build_name=" + sigungu_build_name + ", build_detail=" + build_detail + ", address_detail="
				+ address_detail + "]";
	}
	
	
	
}
