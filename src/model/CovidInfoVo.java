package model;

public class CovidInfoVo {
	
	// Field
	private String  id;
	private String  num;
	private String  vaccine;
	private String  test_date;
	private String  test_hospital;
	private String  test_result;
	private String  symptom;
	
	// Contructor
	public CovidInfoVo() {
	}


	public CovidInfoVo(String id, String num, String vaccine, String test_date, String test_hospital,
			String test_result, String symptom) {
		this.id = id;
		this.num = num;
		this.vaccine = vaccine;
		this.test_date = test_date;
		this.test_hospital = test_hospital;
		this.test_result = test_result;
		this.symptom = symptom;
	}


	public CovidInfoVo(String id, String vaccine, String test_date, String test_hospital, String test_result, String symptom) {
		this.id = id;
		this.vaccine = vaccine;
		this.test_date = test_date;
		this.test_hospital = test_hospital;
		this.test_result = test_result;
		this.symptom = symptom;
		
	}


	public CovidInfoVo(String id, String num) {
		this.id = id;
		this.num = num;

	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getTest_date() {
		return test_date;
	}

	public void setTest_date(String test_date) {
		this.test_date = test_date;
	}

	public String getTest_hospital() {
		return test_hospital;
	}

	public void setTest_hospital(String test_hospital) {
		this.test_hospital = test_hospital;
	}

	public String getTest_result() {
		return test_result;
	}

	public void setTest_result(String test_result) {
		this.test_result = test_result;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}


	@Override
	public String toString() {
		return "CovidInfoVo [id=" + id + ", num=" + num + ", vaccine=" + vaccine + ", test_date=" + test_date
				+ ", test_hospital=" + test_hospital + ", test_result=" + test_result + ", symptom=" + symptom + "]";
	}
	
	
	
	
}






