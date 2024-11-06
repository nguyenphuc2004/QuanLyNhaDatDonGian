package doAnQuanLyGiaoDichNhaDat.domain.model;

import java.util.Date;

public abstract class Transaction {
	private int maGiaoDich;
	private Date ngay;
	private double donGia;
	private double dienTich;

	public Transaction(int maGiaoDich, Date ngay, double donGia, double dienTich) {
		this.maGiaoDich = maGiaoDich;
		this.ngay = ngay;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	public int getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(int maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public abstract double thanhTien();
}
