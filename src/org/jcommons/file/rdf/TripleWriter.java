package org.jcommons.file.rdf;

import org.jcommons.common.StringUtils;

public class TripleWriter
{	
	public static String getTripleLine( String subject, String predicate, String object )
	{
		return subject + " " + predicate + " " + object + " .";
	}
	
	public static String getResourceObjectTriple( String subjectURI, String predicate, String objectURI )
	{
		return getTripleLine( "<"+subjectURI+">", "<"+predicate+">", "<"+objectURI+">" );
	}
	
	public static String getStringValueTriple( String subjectURI, String predicate, String str )
	{
		return getTripleLine( "<"+subjectURI+">", "<"+predicate+">", "\""+StringUtils.getUnicode(str)+"\"@zh" );
	}
	
	public static String getStringValueTripleAT( String subjectURI, String predicate, String str, String language )
	{
		return getTripleLine( "<"+subjectURI+">", "<"+predicate+">", "\""+StringUtils.getUnicode(str)+"\"@" + language );
	}
	
	public static String getValueTriple( String subjectURI, String predicate, String value, String type )
	{
		return getTripleLine( "<"+subjectURI+">", "<"+predicate+">", "\""+value+"\"^^<"+type+">" );
	}
}
