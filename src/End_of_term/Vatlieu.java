package End_of_term;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



// lưu thông tin của vật liệu
public class Vatlieu {
private String mahang;
private String tenhang;
private String donvitinh;
private String nhacungcap;
private String ghichu;
private String ngaynhap;
private float gianhapvao, giabanra;
private int Daban;
private int Tonkhoa;
public Vatlieu() {
	
}
public Vatlieu(String mahang, String tenhang, String donvitinh, String nhacungcap, String ghichu, String ngaynhap,
		float gianhapvao, float giabanra, int daban, int tonkhoa) {
	super();
	this.mahang = mahang;
	this.tenhang = tenhang;
	this.donvitinh = donvitinh;
	this.nhacungcap = nhacungcap;
	this.ghichu = ghichu;
	this.ngaynhap = ngaynhap;
	this.gianhapvao = gianhapvao;
	this.giabanra = giabanra;
	Daban = daban;
	Tonkhoa = tonkhoa;
}
public String getMahang() {
	return mahang;
}
public void setMahang(String mahang) {
	this.mahang = mahang;
}
public String getTenhang() {
	return tenhang;
}
public void setTenhang(String tenhang) {
	this.tenhang = tenhang;
}
public String getDonvitinh() {
	return donvitinh;
}
public void setDonvitinh(String donvitinh) {
	this.donvitinh = donvitinh;
}
public String getNhacungcap() {
	return nhacungcap;
}
public void setNhacungcap(String nhacungcap) {
	this.nhacungcap = nhacungcap;
}
public String getGhichu() {
	return ghichu;
}
public void setGhichu(String ghichu) {
	this.ghichu = ghichu;
}
public String getNgaynhap() {
	return ngaynhap;
}
public void setNgaynhap(String ngaynhap) {
	this.ngaynhap = ngaynhap;
}
public float getGianhapvao() {
	return gianhapvao;
}
public void setGianhapvao(float gianhapvao) {
	this.gianhapvao = gianhapvao;
}
public float getGiabanra() {
	return giabanra;
}
public void setGiabanra(float giabanra) {
	this.giabanra = giabanra;
}
public int getDaban() {
	return Daban;
}
public void setDaban(int daban) {
	Daban = daban;
}
public int getTonkhoa() {
	return Tonkhoa;
}
public void setTonkhoa(int tonkhoa) {
	Tonkhoa = tonkhoa;
}


}
