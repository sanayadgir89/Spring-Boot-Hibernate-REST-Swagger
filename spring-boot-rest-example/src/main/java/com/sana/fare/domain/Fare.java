package com.sana.fare.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "fare")
public class Fare {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "zone_id", nullable = false)
	private long zone_id;

	@Column(name = "tariff_id", nullable = false)
	private long tariff_id;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date start_date;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date created_at;

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date updated_at;

	@Column(name = "create_user_id", nullable = false)
	private long create_user_id;

	@Column(name = "updated_user_id", nullable = false)
	private long updated_user_id;

	@Column(name = "active", nullable = false)
	private boolean active;

	public Fare() {
	}

	public Fare(long id, long zone_id, long tariff_id, BigDecimal amount,
			Date start_date, Date created_at, Date updated_at,
			long create_user_id, long updated_user_id, boolean active) {
		super();
		this.id = id;
		this.zone_id = zone_id;
		this.tariff_id = tariff_id;
		this.amount = amount;
		this.start_date = start_date;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.create_user_id = create_user_id;
		this.updated_user_id = updated_user_id;
		this.active = active;
	}

	public long getId() {
		return this.id;
	}

	// for tests ONLY
	public void setId(long id) {
		this.id = id;
	}

	public long getZone_id() {
		return zone_id;
	}

	public void setZone_id(long zone_id) {
		this.zone_id = zone_id;
	}

	public long getTariff_id() {
		return tariff_id;
	}

	public void setTariff_id(long tariff_id) {
		this.tariff_id = tariff_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public long getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(long create_user_id) {
		this.create_user_id = create_user_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public long getUpdated_user_id() {
		return updated_user_id;
	}

	public void setUpdated_user_id(long updated_user_id) {
		this.updated_user_id = updated_user_id;
	}

	@Override
	public String toString() {
		return "Fare [id=" + id + ", zone_id=" + zone_id + ", tariff_id="
				+ tariff_id + ", amount=" + amount + ", start_date="
				+ start_date + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", create_user_id=" + create_user_id
				+ ", updated_user_id=" + updated_user_id + ", active=" + active
				+ "]";
	}

}
