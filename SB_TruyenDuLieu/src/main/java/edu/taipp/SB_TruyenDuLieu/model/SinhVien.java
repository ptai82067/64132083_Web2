package edu.taipp.SB_TruyenDuLieu.model;

public class SinhVien {
	private String id;
	private String hoTen;
	private int namSinh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public SinhVien(String id, String hoTen, int namSinh) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	
}
