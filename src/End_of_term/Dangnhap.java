package End_of_term;

public class Dangnhap {
private String hovaten;
private String sdt;
private String matkhau;
private String xacnhanmk;

private String loainguoidung;
private String diachi;
private String tendangnhap;
public Dangnhap() {
}
public Dangnhap(String hovaten, String sdt, String matkhau, String loainguoidung, String diachi, String tendangnhap, String xacnhanmk) {
	this.hovaten = hovaten;
	this.sdt = sdt;
	this.matkhau = matkhau;
	this.loainguoidung = loainguoidung;
	this.diachi = diachi;
	this.tendangnhap = tendangnhap;
	this.xacnhanmk = xacnhanmk;
}
public String getHovaten() {
	return hovaten;
}
public void setHovaten(String hovaten) {
	this.hovaten = hovaten;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public String getMatkhau() {
	return matkhau;
}
public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}
public String getLoainguoidung() {
	return loainguoidung;
}
public void setLoainguoidung(String loainguoidung) {
	this.loainguoidung = loainguoidung;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getTendangnhap() {
	return tendangnhap;
}
public void setTendangnhap(String tendangnhap) {
	this.tendangnhap = tendangnhap;
}
public String getXacnhanmk() {
	return xacnhanmk;
}
public void setXacnhanmk(String xacnhanmk) {
	this.xacnhanmk = xacnhanmk;
}



}
