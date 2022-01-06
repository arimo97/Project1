package model;

public class SearchDoroVo {
	private String sido;
	private String sigungu;
	private String eup_myeon_dong;
	private String li;
	private String doro;
	private String doro_bon;
	private String doro_bu;
	private String sigungu_build_name;
	private String build_detail;
	
	
	public SearchDoroVo(String sido, String sigungu, String eup_myeon_dong, String li, String doro, String doro_bon,
			String doro_bu, String sigungu_build_name, String build_detail) {
		super();
		this.sido = sido;
		this.sigungu = sigungu;
		this.eup_myeon_dong = eup_myeon_dong;
		this.li = li;
		this.doro = doro;
		this.doro_bon = doro_bon;
		this.doro_bu = doro_bu;
		this.sigungu_build_name = sigungu_build_name;
		this.build_detail = build_detail;
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
	@Override
	public String toString() {
		return "SearchDoroVo [sido=" + sido + ", sigungu=" + sigungu + ", eup_myeon_dong=" + eup_myeon_dong + ", li="
				+ li + ", doro=" + doro + ", doro_bon=" + doro_bon + ", doro_bu=" + doro_bu + ", sigungu_build_name="
				+ sigungu_build_name + ", build_detail=" + build_detail + "]";
	}
	
	
}
