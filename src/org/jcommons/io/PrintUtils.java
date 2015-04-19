package org.jcommons.io;

import java.util.Set;
import java.util.TreeSet;

import org.jcommons.file.java.model.FullyQualifiedJavaType;

public class PrintUtils {
	private static final String lineSeparator;

    static {
        String ls = System.getProperty("line.separator");
        if (ls == null) {
            ls = "\n";
        }
        lineSeparator = ls;
    }

    private PrintUtils() {
        super();
    }
    
    /**
     * 
     * @param sb
     * @param indentLevel
     */
    public static void javaIndent(StringBuilder sb, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            sb.append("    ");
        }
    }
    
    /**
     * 
     * @param sb
     * @param indentLevel
     */
    public static void xmlIndent(StringBuilder sb, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            sb.append("  ");
        }
    }
    
    /**
     * 
     * @param sb
     */
    public static void newLine(StringBuilder sb) {
        sb.append(lineSeparator);
    }
    
    /**
     * 
     * @param importedTypes
     * @return
     */
    public static Set<String> calculateImports(
            Set<FullyQualifiedJavaType> importedTypes) {
        StringBuilder sb = new StringBuilder();
        Set<String> importStrings = new TreeSet<String>();
        for (FullyQualifiedJavaType fqjt : importedTypes) {
            for (String importString : fqjt.getImportList()) {
                sb.setLength(0);
                sb.append("import "); //$NON-NLS-1$
                sb.append(importString);
                sb.append(';');
                importStrings.add(sb.toString());
            }
        }

        return importStrings;
    }
}
