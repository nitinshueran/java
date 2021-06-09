package com.shu.nitin.companies.zalando;

import java.util.stream.Stream;

class ProductionLineTester {

	private final ProductVerifier verifier;

	ProductionLineTester(ProductVerifier verifier) {
		this.verifier = verifier;
	}

	ProductLineTestReport test(Stream<Product> products) {
		Count count = new Count(0l, 0l, 0l, 0l);
		if (null != products) {
			products.filter(item -> null != item).filter(item -> !"invalid".equalsIgnoreCase(item.getStatus()))
					.distinct().skip(10).limit(20).spliterator().forEachRemaining(product -> {
						try {
							verifier.verify(product);
							count.updateCorrectCnt();
						} catch (RuntimeException ex) {
							count.updateUnCheckedExcCnt();
						} catch (Exception e) {
							count.updateCheckedExcCnt();
						} catch (Error e) {
							count.updateOtherExcCnt();
						}
					});

		}
		return new ProductLineTestReport(count.getCorrectCnt(), count.getCheckedExcCnt(), count.getUncheckedExcCnt(),
				count.getOtherExcCnt());

	}

}

class Count {
	private long correctCnt; // number of correct products
	private long checkedExcCnt; // number of products which threw a checked exception during verification
	private long uncheckedExcCnt; // number of products which threw an unchecked exception during verification
	private long otherExcCnt; // number of products which threw an error during verification

	Count(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
		this.correctCnt = correctCnt;
		this.checkedExcCnt = checkedExcCnt;
		this.uncheckedExcCnt = uncheckedExcCnt;
		this.otherExcCnt = otherExcCnt;
	}

	public void updateCorrectCnt() {
		this.correctCnt = this.correctCnt + 1;
	}

	public void updateCheckedExcCnt() {
		this.checkedExcCnt = this.checkedExcCnt + 1;
	}

	public void updateUnCheckedExcCnt() {
		this.uncheckedExcCnt = this.uncheckedExcCnt + 1;
	}

	public void updateOtherExcCnt() {
		this.otherExcCnt = this.otherExcCnt + 1;
	}

	public long getCorrectCnt() {
		return correctCnt;
	}

	public long getCheckedExcCnt() {
		return checkedExcCnt;
	}

	public long getUncheckedExcCnt() {
		return uncheckedExcCnt;
	}

	public long getOtherExcCnt() {
		return otherExcCnt;
	}

}

class ProductLineTestReport {

	private long correctProductsInLine;
	private long checkedExceptionsCount;
	private long uncheckedExceptionCount;
	private long otherExceptionCount;

	public ProductLineTestReport(long correctProductsInLine, long checkedExceptionsCount, long uncheckedExceptionCount,
			long otherExceptionCount) {
		super();
		this.correctProductsInLine = correctProductsInLine;
		this.checkedExceptionsCount = checkedExceptionsCount;
		this.uncheckedExceptionCount = uncheckedExceptionCount;
		this.otherExceptionCount = otherExceptionCount;
	}

	public void setCorrectProductsInLine(long correctProductsInLine) {
		this.correctProductsInLine = correctProductsInLine;
	}

	public void setCheckedExceptionsCount(long checkedExceptionsCount) {
		this.checkedExceptionsCount = checkedExceptionsCount;
	}

	public void setUncheckedExceptionCount(long uncheckedExceptionCount) {
		this.uncheckedExceptionCount = uncheckedExceptionCount;
	}

	public void setOtherExceptionCount(long otherExceptionCount) {
		this.otherExceptionCount = otherExceptionCount;
	}

	public long getCorrectProductsInLine() {
		return correctProductsInLine;
	}

	public long getCheckedExceptionsCount() {
		return checkedExceptionsCount;
	}

	public long getUncheckedExceptionCount() {
		return uncheckedExceptionCount;
	}

	public long getOtherExceptionCount() {
		return otherExceptionCount;
	}

}

interface ProductVerifier {

	void verify(Product product) throws Exception;

}

class Product {

	private String status;

	public Product(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
