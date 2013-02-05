<?xml version="1.0" encoding="UTF-8"?>
<!-- $Header$ -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN" 
	doctype-system="http://www.w3.org/TR/html4/loose.dtd" indent="yes"/>

<xsl:template name="message">
<xsl:value-of disable-output-escaping="yes" select="."/>
</xsl:template>

<xsl:template name="priorityDiv">
<xsl:if test="@priority = 2">p2</xsl:if>
</xsl:template>

<xsl:template name="timestamp">
	<xsl:value-of select="substring-before(//pmd/@timestamp, 'T')"/> - <xsl:value-of select="substring-before(substring-after(//pmd/@timestamp, 'T'), '.')"/>
</xsl:template>

<xsl:template match="pmd">
<html>
<head>
    <title>PMD <xsl:value-of select="//pmd/@version"/> Report</title>
	<script type="text/javascript" src="fcoltable.js"></script>
    <style type="text/css">
		@import "fcoltable.css";
        body { margin-left: 2%; margin-right: 2%; font:normal verdana,arial,helvetica; color:#000000; }
        table.sortable tr th { font-weight: bold; text-align:left; background:#a6caf0; }
        table.sortable tr td { background:#eeeee0; }
        table.classcount tr th { font-weight: bold; text-align:left; background:#a6caf0; }
        table.classcount tr td { background:#eeeee0; }
        table.summary tr th { font-weight: bold; text-align:left; background:#a6caf0; }
        table.summary tr td { background:#eeeee0; text-align:center;}
		 .p1 { background:#FF9999; }
        .p2 { background:#FFCC66; }
        .p3 { background:#FFFF99; }
        .p4 { background:#99FF99; }
        .p5 { background:#9999FF; }
		div.top{text-align:right;margin:1em 0;padding:0}
		div.top div{display:inline;white-space:nowrap}
		div.top div.left{float:left}
		#content>div.top{display:table;width:100%}
		#content>div.top div{display:table-cell}
		#content>div.top div.left{float:none;text-align:left}
		#content>div.top div.right{text-align:right}
		#topbar{
			position:absolute;
			border: 1px solid black;
			padding: 2px;
			background-color: lightyellow;
			width: 620px;
			visibility: hidden;
			z-index: 100;
		}
    </style>
</head>
<body>
    <H1><div class="top"><div class="left">PMD <xsl:value-of select="//pmd/@version"/> Report</div><div class="right"><xsl:call-template name="timestamp"/></div></div></H1>
    <hr/>
    <h2>Summary</h2>
    <table border="0" class="summary">
      <tr>
        <th>Files</th>
        <th>Total</th>
        <th>Priority 2</th>
      </tr>
      <tr>
        <td><xsl:value-of select="count(//file)"/></td>
        <td><xsl:value-of select="count(//violation)"/></td>
        <td><div class="p2"><xsl:value-of select="count(//violation[@priority = 2])"/></div></td>
      </tr>
    </table>
    <hr/>
    <xsl:for-each select="file[violation/@priority=2]">
        <xsl:sort data-type="number" order="descending" select="count(violation[@priority = 2])"/>
        <xsl:variable name="filename" select="@name"/>
        <H3><xsl:value-of disable-output-escaping="yes" select="substring-before(translate(@name,'/','.'),'.java')"/></H3>
        <table border="0" width="100%" class="footcollapse"><xsl:attribute name="id">sortable_id_<xsl:value-of select="position()"/></xsl:attribute>
            <thead>
				<tr>
					<th>Prio</th>
					<th>Begin Line</th>
					<th>Method</th>
					<th align="left">Description</th>
				</tr>
			</thead>
	        <tfoot>
				<tr>
					<th colspan="3">Total number of violations for this class: <xsl:value-of select="count(violation[@priority = 2])"/> (Click anywhere on this row to see/hide details)</th>
					<td></td>
				</tr>
			</tfoot>
	    <xsl:for-each select="violation[@priority = '2']">
		    <tbody>
				<tr>
					<td style="padding: 3px" align="right"><div><xsl:attribute name="class"><xsl:call-template name="priorityDiv"/></xsl:attribute><xsl:value-of disable-output-escaping="yes" select="@priority"/></div></td>
					<td style="padding: 3px" align="right"><xsl:value-of disable-output-escaping="yes" select="@beginline"/></td>
					<td style="padding: 3px" align="left"><xsl:value-of disable-output-escaping="yes" select="@method"/></td>
					<td style="padding: 3px" align="left" width="100%"><xsl:if test="@externalInfoUrl"><a><xsl:attribute name="href"><xsl:value-of select="@externalInfoUrl"/></xsl:attribute><xsl:call-template name="message"/></a></xsl:if><xsl:if test="not(@externalInfoUrl)"><xsl:call-template name="message"/></xsl:if></td>
				</tr>
			</tbody>
	    </xsl:for-each>
		</table>
		
        <br/>
    </xsl:for-each>
    <p>Generated by <a href="http://pmd.sourceforge.net">PMD <b><xsl:value-of select="//pmd/@version"/></b></a> on <xsl:call-template name="timestamp"/>.</p>
    
    
</body>
</html>
</xsl:template>

</xsl:stylesheet>
