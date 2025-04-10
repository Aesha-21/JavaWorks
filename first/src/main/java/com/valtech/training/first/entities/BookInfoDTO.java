package com.valtech.training.first.entities;

public class BookInfoDTO {
	
	
		private String publisherName;
		private int price;
		
		public BookInfoDTO(String pName,int price) {
			this.publisherName = pName;
			this.price = price;
		}

		public String getPublisherName() {
			return publisherName;
		}

		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "BookInfoDTO [publisherName=" + publisherName + ", price=" + price + "]";
		}
		
		
	}


