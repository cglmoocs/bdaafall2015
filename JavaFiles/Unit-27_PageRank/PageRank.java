// package com.mooc.xinformatics.pagerank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * To get the PageRank of a website according to google
 *  
 * Compilation:  javac PageRank.java
 * Execution:    java  JenkinsHash PageRank
 * Dependencies: Jenkins Hash
 *
 */
public class PageRank {
	
	public static final String URL_FORMAT = "http://toolbarqueries.google.com/tbr?client=navclient-auto&ch=6%s&features=Rank&q=info:%s";

	/**
	 * Appends the given URL into final URL
	 * @param domain - domain name of the page
	 * @return
	 */
	public String createFinalURL(String domain) {
		JenkinsHash jenkinsHash = new JenkinsHash();
		long hashValue = jenkinsHash.hash(("info:" + domain).getBytes());
		String url = String.format(URL_FORMAT, hashValue, domain);
		return url;
	}

	/**
	 * Retrieves the Page Rank of the given domain name
	 * @param domain - domain name of the page
	 * @return page rank 
	 */ 
	public int getPageRank(String domain) {

		String googleResult = null;
		String streamOutput = null;
		URLConnection connection = null;
		BufferedReader bufferedReader = null;
		try {
			connection = new URL(createFinalURL(domain)).openConnection();
			bufferedReader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((streamOutput = bufferedReader.readLine()) != null) {
				googleResult = streamOutput.split(":")[2].trim();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return Integer.parseInt(googleResult);
	}

	public static void main(String args[]) {
		PageRank pr = new PageRank();
		System.out.println("Page Rank of Wikipeida(http://en.wikipedia.org) :: " + pr.getPageRank("http://en.wikipedia.org"));
		System.out.println("Page Rank of SOIC(http://www.soic.indiana.edu) :: " + pr.getPageRank("http://www.soic.indiana.edu"));
		System.out.println("Page Rank of IU(http://iu.edu) :: " + pr.getPageRank("http://iu.edu"));
	}

}
