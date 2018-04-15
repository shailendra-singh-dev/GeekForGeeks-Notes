package main;

import java.util.*;

public class UniqueImages {

	public static void main(String[] args) {
		Image[] images = new Image[] { new Image("flag.jpg", 40, 60),
				new Image("flag.gif", 40, 60),
				new Image("smile.gif", 100, 200),
				new Image("smile.gif", 50, 400),
				new Image("other.jpg", 40, 60),
				new Image("lenna.jpg", 512, 512),
				new Image("Lenna.jpg", 512, 512) };

		Set<Image> set = new HashSet<Image>(Arrays.asList(images));
		Image.print(set);
	}

	public static class Image {
		private String fileName;
		private int width;
		private int height;

		public Image(String name, int width, int height) {
			this.fileName = name;
			this.width = width;
			this.height = height;
		}

		public String getFileName() {
			return fileName;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public boolean equals(Object obj) {
			Image o = (Image) obj;
			if (fileName == null || o.getFileName() == null) {
				return false;
			}
			String[] components = fileName.split("\\.");
			String[] ocmponents = o.getFileName().split("\\.");
			return components[0].equals(ocmponents[0])
					&& width * height == o.getWidth() * o.getHeight();
		}

		@Override
		public int hashCode() {
			return width * height;
		}

		@Override
		public String toString() {
			return "Image:fileName:" + fileName + " size:" + width * height;
		}

		public static void print(Set<Image> set) {
			for (Image image : set) {
				System.out.println(image);
			}
		}

	}

}
