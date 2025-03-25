package edu.taipp.SB_TongHopGK.model;

public class SinhVien {
	private String MSSV;
	private String hoTen;
	private float diemTB;
	public SinhVien(String mSSV, String hoTen, float diemTB) {
		
		MSSV = mSSV;
		this.hoTen = hoTen;
		this.diemTB = diemTB;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}
	
}
