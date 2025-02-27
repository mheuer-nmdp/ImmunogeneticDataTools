package org.dash;

import java.io.IOException;
import java.util.LinkedHashMap;

import junit.framework.TestCase;

import org.dash.valid.LinkageDisequilibriumAnalyzer;
import org.dash.valid.gl.GLStringUtilities;
import org.dash.valid.report.DetectedLinkageFindings;
import org.immunogenomics.gl.MultilocusUnphasedGenotype;
import org.junit.Test;

public class LinkageDisequilibriumAnalyzerTest extends TestCase {	
	@Test
	public void testLinkageReportingExamples() {
		LinkageDisequilibriumAnalyzer.main(new String[] {"contrivedExamples.txt", "fullyQualifiedExample.txt", "strictExample.txt", "shorthandExamples.txt"});
	}
	
	@Test
	public void testLinkageReportingMugs() {
		LinkedHashMap<String, String> glStrings = GLStringUtilities.readGLStringFile("fullyQualifiedExample.txt");
		
		for (String key : glStrings.keySet()) {
			MultilocusUnphasedGenotype mug = GLStringUtilities.convertToMug(glStrings.get(key));
			
			assertNotNull(mug);
			
			DetectedLinkageFindings findings = LinkageDisequilibriumAnalyzer.detectLinkages(mug);
			
			assertNotNull(findings);
		}
	}
	
	@Test
	public void testLinkageReportingInlineGLString() throws IOException {
		String fullyQualified = GLStringUtilities.fullyQualifyGLString("HLA-A*01:01:01:01+HLA-A*24:02:01:01/HLA-A*24:02:01:03^HLA-B*08:01:01/HLA-B*08:18/HLA-B*08:39/HLA-B*08:92/HLA-B*08:93+HLA-B*35:02:01/HLA-B*35:211^HLA-C*04:01:01:01/HLA-C*04:01:01:02/HLA-C*04:01:01:03/HLA-C*04:01:01:04/HLA-C*04:01:01:05/HLA-C*04:20/HLA-C*04:117+HLA-C*07:01:01:01/HLA-C*07:01:01:02/HLA-C*07:01:31/HLA-C*07:103/HLA-C*07:230^HLA-DPA1*01:03:01:01/HLA-DPA1*01:03:01:02/HLA-DPA1*01:03:01:03/HLA-DPA1*01:03:01:04/HLA-DPA1*01:03:01:05+HLA-DPA1*02:01:01^HLA-DPB1*02:01:02+HLA-DPB1*17:01^HLA-DQA1*02:01+HLA-DQA1*05:01:01:01/HLA-DQA1*05:01:01:02^HLA-DQB1*02:01:01+HLA-DQB1*02:02^HLA-DRB1*03:01:01:01/HLA-DRB1*03:01:01:02+HLA-DRB1*07:01:01:01/HLA-DRB1*07:01:01:02^HLA-DRB3*01:01:02:01/HLA-DRB3*01:01:02:02^HLA-DRB4*01:03:01:01/HLA-DRB4*01:03:01:03");

		MultilocusUnphasedGenotype mug = GLStringUtilities.convertToMug(fullyQualified);
		DetectedLinkageFindings findings = LinkageDisequilibriumAnalyzer.detectLinkages(mug);
		
		assertNotNull(findings);		
	}
}
