<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:doc="http://nwalsh.com/xsl/documentation/1.0" xmlns:src="http://nwalsh.com/xmlns/litprog/fragment" exclude-result-prefixes="src" version="1.0">

<!-- ********************************************************************
     $Id: param.xsl 903 2006-06-21 22:32:15Z johnson $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://nwalsh.com/docbook/xsl/ for copyright
     and other information.

     ******************************************************************** -->

<doc:refentry><refmeta>
<refentrytitle>admon.graphics.extension</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>admon.graphics.extension</refname>
<refpurpose>Extension for admonition graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the extension to use on admonition graphics.</para>

</refsect1>
</doc:refentry>
<xsl:param name="admon.graphics.extension" select="'.png'"/>

<doc:refentry><refmeta>
<refentrytitle>admon.graphics.path</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>admon.graphics.path</refname>
<refpurpose>Path to admonition graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the path, probably relative to the directory where the HTML
files are created, to the admonition graphics.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="admon.graphics.path">images/</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>admon.graphics</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>admon.graphics</refname>
<refpurpose>Use graphics in admonitions?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), admonitions are presented in an alternate style that uses
a graphic.  Default graphics are provided in the distribution.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="admon.graphics" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>admon.textlabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>admon.textlabel</refname>
<refpurpose>Use text label in admonitions?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), admonitions are presented with a generated
text label such as Note or Warning in the appropriate language.
If zero, such labels are turned off, but any title child
of the admonition element are still output.
The default value is 1.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="admon.textlabel" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>admon.style</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>admon.style</refname>
<refpurpose>CSS style attributes for admonitions</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies the value of the <sgmltag class="attribute">STYLE</sgmltag>
attribute that should be added to admonitions.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="admon.style">
  <xsl:text>margin-left: 0.5in; margin-right: 0.5in;</xsl:text>
</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>callout.defaultcolumn</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.defaultcolumn</refname>
<refpurpose>Indicates what column callouts appear in by default</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If a callout does not identify a column (for example, if it uses
the <literal>linerange</literal> <sgmltag class="attribute">unit</sgmltag>),
it will appear in the default column.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.defaultcolumn" select="'60'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.graphics.extension</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.graphics.extension</refname>
<refpurpose>Extension for callout graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the extension to use on callout graphics.</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.graphics.extension" select="'.png'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.graphics.number.limit</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.graphics.number.limit</refname>
<refpurpose>Number of the largest callout graphic</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>callout.graphics</parameter>
is non-zero, graphics are used to represent
callout numbers. The value of
<parameter>callout.graphics.number.limit</parameter>
is
the largest number for which a graphic exists. If the callout number
exceeds this limit, the default presentation "(nnn)" will always
be used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.graphics.number.limit" select="'15'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.graphics.path</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.graphics.path</refname>
<refpurpose>Path to callout graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the path, probably relative to the directory where the HTML
files are created, to the callout graphics.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.graphics.path" select="'images/callouts/'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.graphics</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.graphics</refname>
<refpurpose>Use graphics for callouts?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, callouts are presented with graphics (e.g., reverse-video
circled numbers instead of "(1)", "(2)", etc.).
Default graphics are provided in the distribution.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.graphics" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.list.table</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.list.table</refname>
<refpurpose>Present callout lists using a table?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The default presentation of <sgmltag>CalloutList</sgmltag>s uses
an HTML <sgmltag>DL</sgmltag>. Some browsers don't align DLs very well
if <parameter>callout.graphics</parameter> are used. With this option
turned on, <sgmltag>CalloutList</sgmltag>s are presented in an HTML
<sgmltag>TABLE</sgmltag>, which usually results in better alignment
of the callout number with the callout description.</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.list.table" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.unicode.number.limit</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.unicode.number.limit</refname>
<refpurpose>Number of the largest callout graphic</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>callout.unicode</parameter>
is non-zero, unicode characters are used to represent
callout numbers. The value of
<parameter>callout.unicode.number.limit</parameter>
is
the largest number for which a unicode character exists. If the callout number
exceeds this limit, the default presentation "(nnn)" will always
be used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.unicode.number.limit" select="'10'"/>

<doc:refentry><refmeta>
<refentrytitle>callout.unicode.start.character</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.unicode.start.character</refname>
<refpurpose>First Unicode character to use, decimal value.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>callout.graphics</parameter> is zero and <parameter>callout.unicode</parameter>
is non-zero, unicode characters are used to represent
callout numbers. The value of
<parameter>callout.unicode.start.character</parameter>
is the decimal unicode value used for callout number one. Currently, 
only 10102 is supported in the stylesheets for this parameter. 
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.unicode.start.character" select="10102"/>

<doc:refentry><refmeta>
<refentrytitle>callout.unicode</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>callout.unicode</refname>
<refpurpose>Use Unicode characters rather than images for callouts.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The stylesheets can use either an image of the numbers one to ten, or the single Unicode character which represents the numeral, in white on a black background. Use this to select the Unicode character option.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callout.unicode" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>callouts.extension</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>callouts.extension</refname>
<refpurpose>Enable the callout extension</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The callouts extension processes <sgmltag>areaset</sgmltag>
elements in <sgmltag>ProgramListingCO</sgmltag> and other text-based
callout elements.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="callouts.extension" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>ebnf.table.bgcolor</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>ebnf.table.bgcolor</refname>
<refpurpose>Background color for EBNF tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the background color for EBNF tables. No <sgmltag>bgcolor</sgmltag>
attribute is output if <varname>ebnf.table.bgcolor</varname> is set to
the null string. The default value matches the value used in recent
online versions of the W3C's XML Spec productions.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ebnf.table.bgcolor" select="'#F5DCB3'"/>

<doc:refentry><refmeta>
<refentrytitle>ebnf.table.border</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>ebnf.table.border</refname>
<refpurpose>Selects border on EBNF tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Selects the border on EBNF tables. If non-zero, the tables have
borders, otherwise they don't.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ebnf.table.border" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>ebnf.assignment</refentrytitle>
<refmiscinfo role="type">rtf</refmiscinfo>
</refmeta><refnamediv>
<refname>ebnf.assignment</refname>
<refpurpose>The EBNF production assignment operator</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>ebnf.assignment</parameter> parameter determines what
text is used to show <quote>assignment</quote> in <sgmltag>production</sgmltag>s
in <sgmltag>productionset</sgmltag>s.</para>

<para>While <quote><literal>::=</literal></quote> is common, so are several
other operators.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ebnf.assignment">
<code>::=</code>
</xsl:param>


<doc:refentry><refmeta>
<refentrytitle>ebnf.statement.terminator</refentrytitle>
<refmiscinfo role="type">rtf</refmiscinfo>
</refmeta><refnamediv>
<refname>ebnf.statement.terminator</refname>
<refpurpose>Punctuation that ends an EBNF statement.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>ebnf.statement.terminator</parameter> parameter determines what
text is used to terminate each <sgmltag>production</sgmltag>
in <sgmltag>productionset</sgmltag>.</para>

<para>Some notations end each statement with a period.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ebnf.statement.terminator"/>


<doc:refentry><refmeta>
<refentrytitle>annotate.toc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotate.toc</refname>
<refpurpose>Annotate the Table of Contents?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, TOCs will be annotated. At present, this just means
that the <sgmltag>RefPurpose</sgmltag> of <sgmltag>RefEntry</sgmltag>
TOC entries will be displayed.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotate.toc" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>autotoc.label.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>autotoc.label.separator</refname>
<refpurpose>Separator between labels and titles in the ToC</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>String to use to seperate labels and title in a table of contents.</para>

</refsect1>
</doc:refentry>
<xsl:param name="autotoc.label.separator" select="'. '"/>

<doc:refentry><refmeta>
<refentrytitle>autotoc.label.in.hyperlink</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>autotoc.label.in.hyperlink</refname>
<refpurpose>Include lable in hyperlinked titles in TOC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If the value of
<parameter>autotoc.label.in.hyperlink</parameter> is non-zero, labels
are included in hyperlinked titles in the TOC. If it is instead zero,
labels are still displayed prior to the hyperlinked titles, but
are not hyperlinked along with the titles.</para>

</refsect1>
</doc:refentry>
<xsl:param name="autotoc.label.in.hyperlink" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>process.source.toc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>process.source.toc</refname>
<refpurpose>Process a non-empty <sgmltag>toc</sgmltag> element if it occurs in a source document?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies that the contents of a non-empty "hard-coded"
<sgmltag>toc</sgmltag> element in a source document are processed to
generate a TOC in output.
<note>
  <para>This parameter has no effect on automated generation of
  TOCs. An automated TOC may still be generated along with the
  "hard-coded" TOC. To suppress automated TOC generation, adjust the
  value of the <parameter>generate.toc</parameter> paramameter.</para>

  <para>The <sgmltag>process.source.toc</sgmltag> parameter also has
  no effect if the <sgmltag>toc</sgmltag> element is empty; handling
  for empty <sgmltag>toc</sgmltag> is controlled by the
  <parameter>process.empty.source.toc</parameter> parameter.</para>
</note>
</para>

</refsect1>
</doc:refentry>
<xsl:param name="process.source.toc" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>process.empty.source.toc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>process.empty.source.toc</refname>
<refpurpose>Generate automated TOC if <sgmltag>toc</sgmltag> element occurs in a source document?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies that if an empty <sgmltag>toc</sgmltag> element is
found in a source document, an automated TOC is generated.
<note>
  <para>Depending on what the value of the
  <parameter>generate.toc</parameter> parameter is, setting this
  parameter to <literal>1</literal> could result in generation of
  duplicate automated TOCs. So the
  <parameter>process.empty.source.toc</parameter> is primarily useful
  as an "override": by placing an empty <sgmltag>toc</sgmltag> in your
  document and setting this parameter to <literal>1</literal>, you can
  force a TOC to be generated even if <sgmltag>generate.toc</sgmltag>
  says not to.</para>
</note>
</para>

</refsect1>
</doc:refentry>
<xsl:param name="process.empty.source.toc" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>bridgehead.in.toc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>bridgehead.in.toc</refname>
<refpurpose>Should bridgehead elements appear in the TOC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, bridgeheads appear in the TOC. Note that this option
is not fully supported and may be removed in a future version of the
stylesheets.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="bridgehead.in.toc" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>simplesect.in.toc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>simplesect.in.toc</refname>
<refpurpose>Should <sgmltag>simplesect</sgmltag> elements appear in the TOC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, <sgmltag>simplesect</sgmltag>s appear in the TOC.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="simplesect.in.toc" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>manual.toc</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>manual.toc</refname>
<refpurpose>An explicit TOC to be used for the TOC</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>manual.toc</parameter> identifies an explicit TOC that
will be used for building the printed TOC.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="manual.toc" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>toc.list.type</refentrytitle>
<refmiscinfo role="type">list</refmiscinfo>
<refmiscinfo role="value">dl</refmiscinfo>
<refmiscinfo role="value">ul</refmiscinfo>
<refmiscinfo role="value">ol</refmiscinfo>
</refmeta><refnamediv>
<refname>toc.list.type</refname>
<refpurpose>Type of HTML list element to use for Tables of Contents</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When an automatically generated Table of Contents (or List of Titles)
is produced, this HTML element will be used to make the list.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="toc.list.type">dl</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>toc.section.depth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>toc.section.depth</refname>
<refpurpose>How deep should recursive <sgmltag>section</sgmltag>s appear
in the TOC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies the depth to which recursive sections should appear in the
TOC.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="toc.section.depth">2</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>toc.max.depth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>toc.max.depth</refname>
<refpurpose>How maximaly deep should be each TOC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies the maximal depth of TOC on all levels.</para>

</refsect1>
</doc:refentry>
<xsl:param name="toc.max.depth">8</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>generate.toc</refentrytitle>
<refmiscinfo role="type">table</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.toc</refname>
<refpurpose>Control generation of ToCs and LoTs</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter has a structured value. It is a table of space-delimited
path/value pairs. Each path identifies some element in the source document
using a restricted subset of XPath (only the implicit child axis, no wildcards,
no predicates). Paths can be either relative or absolute.</para>

<para>When processing a particular element, the stylesheets consult this table to
determine if a ToC (or LoT(s)) should be generated.</para>

<para>For example, consider the entry:</para>

<screen>book toc,figure</screen>

<para>This indicates that whenever a <sgmltag>book</sgmltag> is formatted, a
Table Of Contents and a List of Figures should be generated. Similarly,</para>

<screen>/chapter toc</screen>

<para>indicates that whenever a document <emphasis>that has a root
of</emphasis> <sgmltag>chapter</sgmltag> is formatted, a Table of
Contents should be generated. The entry <literal>chapter</literal> would match
all chapters, but <literal>/chapter</literal> matches only <sgmltag>chapter</sgmltag>
document elements.</para>

<para>Generally, the longest match wins. So, for example, if you want to distinguish
articles in books from articles in parts, you could use these two entries:</para>

<screen>book/article toc,figure
part/article toc</screen>

<para>Note that an article in a part can never match a <literal>book/article</literal>,
so if you want nothing to be generated for articles in parts, you can simply leave
that rule out.</para>

<para>If you want to leave the rule in, to make it explicit that you're turning
something off, use the value <quote>nop</quote>. For example, the following
entry disables ToCs and LoTs for articles:</para>

<screen>article nop</screen>

<para>Do not simply leave the word <quote>article</quote> in the file
without a matching value. That'd be just begging the silly little
path/value parser to get confused.</para>

<para>Section ToCs are further controlled by the
<parameter>generate.section.toc.level</parameter> parameter.
For a given section level to have a ToC, it must have both an entry in 
<parameter>generate.toc</parameter> and be within the range enabled by
<parameter>generate.section.toc.level</parameter>.</para>
</refsect1>
</doc:refentry>
<xsl:param name="generate.toc">
appendix  toc,title
article/appendix  nop
article   toc,title
book      toc,title,figure,table,example,equation
chapter   toc,title
part      toc,title
preface   toc,title
qandadiv  toc
qandaset  toc
reference toc,title
sect1     toc
sect2     toc
sect3     toc
sect4     toc
sect5     toc
section   toc
set       toc,title
</xsl:param>


<doc:refentry><refmeta>
<refentrytitle>generate.section.toc.level</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.section.toc.level</refname>
<refpurpose>Control depth of TOC generation in sections</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>generate.section.toc.level</parameter> parameter
controls the depth of section in which TOCs will be generated. Note
that this is related to, but not the same as
<parameter>toc.section.depth</parameter>, which controls the depth to
which TOC entries will be generated in a given TOC.</para>
<para>If, for example, <parameter>generate.section.toc.level</parameter>
is <literal>3</literal>, TOCs will be generated in first, second, and third
level sections, but not in fourth level sections.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.section.toc.level" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>generate.index</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.index</refname>
<refpurpose>Do you want an index?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specify if an index should be generated. </para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.index" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>index.method</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>index.method</refname>
<refpurpose>Select method used to group index entries in an index</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter lets you select which method should be
used to sort and group index entries in an index.
Indexes in languages that have accented characters typically
sort together accented words and unaccented words.
So <quote>Á</quote> (A acute) would sort together
with <quote>A</quote>, so both would appear in the <quote>A</quote>
section of the index.
</para>

<para>The default indexing method does not sort accented characters this way.
Words that start with an accented character will instead appear in the
<quote>Symbols</quote> section of the index.
As such, the default method is only suitable for
English and other unaccented languages.
The other indexing methods require extensions of one type or
another, which is why there are not used by default.</para>

<para>The three choices for indexing method are:</para>
<variablelist>
<varlistentry>
<term><literal>english</literal></term>
<listitem>
<para>
(default)  Sort and groups words based only on the Latin alphabet.
Accented words and words in non-Latin alphabets will be
put in the <quote>Symbols</quote> section of the index.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>kosek</literal></term>
<listitem>
<para>
Sort and groups words based on letter groups configured in
the DocBook locale file for the given language.
For example, the French locale file is <filename>common/fr.xml</filename>.
This method requires support for EXSLT extensions in
the XSL processor. It also requires support for using 
user-defined functions in xsl:key (xsltproc does not).
</para>
<para>This method is suitable for any language for which you can
list all the individual characters that should appear
in each letter group in an index.
It is probably not practical to use it for ideographic languages
such as Chinese that have hundreds or thousands of characters.
</para>
<para>To use this method, your customization must set this
parameter and import an additional stylesheet module:</para>
<programlisting>&lt;xsl:import href="[path-to-stylesheets]/common/autoidx-ng.xsl"/&gt;
&lt;xsl:param name="index.method"&gt;kosek&lt;/xsl:param&gt;

</programlisting>
<para>The stylesheet module defines functions and adds an xsl:key
used by the method.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>kimber</literal></term>
<listitem>
<para>
This method uses extensions to the Saxon processor to implement
sophisticated indexing processes.  It uses its own 
configuration file, which can include information for any number of
languages.  Each language's configuration can group
words using either an
enumerated method similar to the kosek method, or it can
designate the first character in each group when viewed in sort order.
The latter configuration is useful for ideographic languages
such as Chinese, Japanese, and Korean.
You can also define your own collation algorithms and where you
want Latin-alphabet words sorted.</para>
<itemizedlist>
<listitem>
<para>For a whitepaper describing the extensions, see:
<ulink url="http://www.innodata-isogen.com/knowledge_center/white_papers/back_of_book_for_xsl_fo.pdf"/>.
</para>
</listitem>
<listitem>
<para>To download the extension library, see
<ulink url="http://www.innodata-isogen.com/knowledge_center/tools_downloads/i18nsupport"/>.
</para>
</listitem>
</itemizedlist>

<para>To use this method, you must:</para>

<orderedlist>
<listitem>
<para>Use Saxon as your XSLT processor.
</para>
</listitem>
<listitem>
<para>Install and configure the Innodata Isogen library, using
the documentation that comes with it.
</para>
</listitem>
<listitem>
<para>Set this parameter's value to <quote>kimber</quote>.
</para>
</listitem>
<listitem>
<para>Import the index extensions stylesheet module
<filename>common/autoidx-ng.xsl</filename> into your
customization.
</para>
</listitem>
</orderedlist>

</listitem>
</varlistentry>
</variablelist>

</refsect1>
</doc:refentry>
<xsl:param name="index.method" select="'english'"/>

<doc:refentry><refmeta>
<refentrytitle>index.on.type</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>index.on.type</refname>
<refpurpose>Select indexterms based on <sgmltag>type</sgmltag>
attribute value</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If non-zero, 
then an <sgmltag>index</sgmltag> element that has a
<sgmltag>type</sgmltag> attribute
value will contain only those <sgmltag>indexterm</sgmltag>
elements with a matching <sgmltag>type</sgmltag> attribute value.
If an <sgmltag>index</sgmltag> has no <sgmltag>type</sgmltag>
attribute or it is blank, then the index will contain
all <sgmltag>indexterm</sgmltag>s in the current scope.
</para>

<para>
If <literal>index.on.type</literal> is zero, then the
<sgmltag>type</sgmltag> attribute has no effect
on selecting indexterms for an index.
</para>

<para>For those using DocBook version 4.2 or earlier,
the <sgmltag>type</sgmltag> attribute is not available
for index terms.  However, you can achieve the same
effect by using the <sgmltag>role</sgmltag> attribute
in the same manner on <sgmltag>indexterm</sgmltag>
and <sgmltag>index</sgmltag>, and setting the stylesheet parameter 
<parameter>index.on.role</parameter> to a nonzero value.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.on.type" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>index.on.role</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>index.on.role</refname>
<refpurpose>Select indexterms based on role value</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If non-zero, 
then an <sgmltag>index</sgmltag> element that has a
<sgmltag>role</sgmltag> attribute
value will contain only those <sgmltag>indexterm</sgmltag>
elements with a matching role value.
If an <sgmltag>index</sgmltag> has no <sgmltag>role</sgmltag>
attribute or it is blank, then the index will contain
all <sgmltag>indexterm</sgmltag>s in the current scope.
</para>
<para>
If <literal>index.on.role</literal> is zero, then the
<sgmltag>role</sgmltag> attribute has no effect
on selecting indexterms for an index.
</para>

<para>If you are using DocBook version 4.3 or later, you should
use the <sgmltag>type</sgmltag> attribute instead of <sgmltag>role</sgmltag>
on <sgmltag>indexterm</sgmltag> and <sgmltag>index</sgmltag>,
and set the <parameter>index.on.type</parameter> to a nonzero
value.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.on.role" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>index.prefer.titleabbrev</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>index.prefer.titleabbrev</refname>
<refpurpose>Should be abbreviated titles used as back references</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.prefer.titleabbrev" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>index.term.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>index.term.separator</refname>
<refpurpose>Override for punctuation separating an index term 
from its list of page references in an index</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter permits you to override
the text to insert between
the end of an index term and its list of page references.
Typically that might be a comma and a space.
</para>

<para>Because this text may be locale dependent,
this parameter's value is normally taken from a gentext
template named 'term-separator' in the
context 'index' in the stylesheet
locale file for the language
of the current document.
This parameter can be used to override the gentext string,
and would typically be used on the command line.
This parameter would apply to all languages.
</para>

<para>So this text string can be customized in two ways.
You can reset the default gentext string using
the <parameter>local.l10n.xml</parameter> parameter, or you can
fill in the content for this normally empty 
override parameter.
The content can be a simple string, or it can be
something more complex such as a call-template.
For fo output, it could be an <sgmltag>fo:leader</sgmltag>
element to provide space of a specific length, or a dot leader.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.term.separator" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>index.number.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>index.number.separator</refname>
<refpurpose>Override for punctuation separating page numbers in index</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter permits you to override the text to insert between
page references in a formatted index entry.  Typically 
that would be a comma and a space.
</para>

<para>Because this text may be locale dependent,
this parameter's value is normally taken from a gentext
template named 'number-separator' in the
context 'index' in the stylesheet
locale file for the language
of the current document.
This parameter can be used to override the gentext string,
and would typically be used on the command line.
This parameter would apply to all languages.
</para>

<para>So this text string can be customized in two ways.
You can reset the default gentext string using
the <parameter>local.l10n.xml</parameter> parameter, or you can
override the gentext with the content of this parameter.
The content can be a simple string, or it can be
something more complex such as a call-template.
</para>

<para>In HTML index output, section title references are used instead of
page number references.  This punctuation appears between
such section titles in an HTML index.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.number.separator" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>index.range.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>index.range.separator</refname>
<refpurpose>Override for punctuation separating the two numbers
in a page range in index</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter permits you
to override the text to insert between
the two numbers of a page range in an index.
This parameter is only used by those XSL-FO processors
that support an extension for generating such page ranges
(such as XEP).</para>

<para>Because this text may be locale dependent,
this parameter's value is normally taken from a gentext
template named 'range-separator' in the
context 'index' in the stylesheet
locale file for the language
of the current document.
This parameter can be used to override the gentext string,
and would typically be used on the command line.
This parameter would apply to all languages.
</para>

<para>So this text string can be customized in two ways.
You can reset the default gentext string using
the <parameter>local.l10n.xml</parameter> parameter, or you can
override the gentext with the content of this parameter.
The content can be a simple string, or it can be
something more complex such as a call-template.
</para>

<para>In HTML index output, section title references are used instead of
page number references. So there are no page ranges
and this parameter has no effect.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="index.range.separator" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>linenumbering.everyNth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>linenumbering.everyNth</refname>
<refpurpose>Indicate which lines should be numbered</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If line numbering is enabled, everyNth line will be numbered.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="linenumbering.everyNth" select="'5'"/>

<doc:refentry><refmeta>
<refentrytitle>linenumbering.extension</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>linenumbering.extension</refname>
<refpurpose>Enable the line numbering extension</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, verbatim environments (elements that have the
format='linespecific' notation attribute: address, literallayout,
programlisting, screen, synopsis) that specify line numbering will
have, surprise, line numbers.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="linenumbering.extension" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>linenumbering.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>linenumbering.separator</refname>
<refpurpose>Specify a separator between line numbers and lines</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The separator is inserted between line numbers and lines in
the verbatim environment.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="linenumbering.separator" select="' '"/>

<doc:refentry><refmeta>
<refentrytitle>linenumbering.width</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>linenumbering.width</refname>
<refpurpose>Indicates the width of line numbers</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If line numbering is enabled, line numbers will appear right
justified in a field "width" characters wide.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="linenumbering.width" select="'3'"/>

<doc:refentry><refmeta>
<refentrytitle>tablecolumns.extension</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>tablecolumns.extension</refname>
<refpurpose>Enable the table columns extension function</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The table columns extension function adjusts the widths of table
columns in the HTML result to more accurately reflect the specifications
in the CALS table.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="tablecolumns.extension" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>textinsert.extension</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>textinsert.extension</refname>
<refpurpose>Enable the textinsert extension element</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The textinsert extension element inserts the contents of a
a file into the result tree (as text).
</para>

</refsect1>
</doc:refentry>
<xsl:param name="textinsert.extension" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>textdata.default.encoding</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>textdata.default.encoding</refname>
<refpurpose>Default encoding of external text files which are included
using textdata element</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Default encoding of external text files which are included using
textdata element. This value is used only when you do not specify
encoding by appropriate attribute directly on textdata. Default
encoding (empty string) is interpreted as system default
encoding.</para>

</refsect1>
</doc:refentry>
<xsl:param name="textdata.default.encoding" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>graphicsize.extension</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>graphicsize.extension</refname>
<refpurpose>Enable the getWidth()/getDepth() extension functions</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero (and if <parameter>use.extensions</parameter> is non-zero
and if you're using a processor that supports extension functions), the
<function>getWidth</function> and <function>getDepth</function> functions
will be used to extract image sizes from graphics.</para>

</refsect1>
</doc:refentry>
<xsl:param name="graphicsize.extension" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>graphicsize.use.img.src.path</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>graphicsize.use.img.src.path</refname>
<refpurpose>Prepend <parameter>img.src.path</parameter> before
filenames passed to extension functions</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero <parameter>img.src.path</parameter> parameter will
be appended before filenames passed to extension functions for
measuring image dimensions.</para>

</refsect1>
</doc:refentry>
<xsl:param name="graphicsize.use.img.src.path" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>use.extensions</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.extensions</refname>
<refpurpose>Enable extensions</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, extensions may be used. Each extension is
further controlled by its own parameter. But if
<parameter>use.extensions</parameter> is zero, no extensions will
be used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="use.extensions" select="'0'"/>

<doc:refentry><refmeta>
<refentrytitle>chapter.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>chapter.autolabel</refname>
<refpurpose>Specifies the labeling format for Chapter titles</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If zero, then chapters will not be numbered.
Otherwise chapters will be numbered, using the parameter value
as the number format if the value matches one of the following:
</para>

<variablelist>
  <varlistentry>
    <term>1 or arabic</term>
    <listitem>
      <para>Arabic numeration (1, 2, 3 ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>A or upperalpha</term>
    <listitem>
      <para>Uppercase letter numeration (A, B, C ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>a or loweralpha</term>
    <listitem>
      <para>Lowercase letter numeration (a, b, c ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>I or upperroman</term>
    <listitem>
      <para>Uppercase roman numeration (I, II, III ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>i or lowerroman</term>
    <listitem>
      <para>Lowercase roman letter numeration (i, ii, iii ...).</para>
    </listitem>
  </varlistentry>
</variablelist>

<para>Any nonzero value other than the above will generate
the default number format (arabic).
</para>

</refsect1>
</doc:refentry>
<xsl:param name="chapter.autolabel" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>appendix.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>appendix.autolabel</refname>
<refpurpose>Specifies the labeling format for Appendix titles</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If zero, then appendices will not be numbered.
Otherwise appendices will be numbered, using the parameter value
as the number format if the value matches one of the following:
</para>

<variablelist>
  <varlistentry>
    <term>1 or arabic</term>
    <listitem>
      <para>Arabic numeration (1, 2, 3 ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>A or upperalpha</term>
    <listitem>
      <para>Uppercase letter numeration (A, B, C ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>a or loweralpha</term>
    <listitem>
      <para>Lowercase letter numeration (a, b, c ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>I or upperroman</term>
    <listitem>
      <para>Uppercase roman numeration (I, II, III ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>i or lowerroman</term>
    <listitem>
      <para>Lowercase roman letter numeration (i, ii, iii ...).</para>
    </listitem>
  </varlistentry>
</variablelist>

<para>Any nonzero value other than the above will generate
the default number format (upperalpha).
</para>

</refsect1>
</doc:refentry>
<xsl:param name="appendix.autolabel" select="'A'"/>

<doc:refentry><refmeta>
<refentrytitle>part.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>part.autolabel</refname>
<refpurpose>Specifies the labeling format for Part titles</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If zero, then parts will not be numbered.
Otherwise parts will be numbered, using the parameter value
as the number format if the value matches one of the following:
</para>

<variablelist>
  <varlistentry>
    <term>1 or arabic</term>
    <listitem>
      <para>Arabic numeration (1, 2, 3 ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>A or upperalpha</term>
    <listitem>
      <para>Uppercase letter numeration (A, B, C ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>a or loweralpha</term>
    <listitem>
      <para>Lowercase letter numeration (a, b, c ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>I or upperroman</term>
    <listitem>
      <para>Uppercase roman numeration (I, II, III ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>i or lowerroman</term>
    <listitem>
      <para>Lowercase roman letter numeration (i, ii, iii ...).</para>
    </listitem>
  </varlistentry>
</variablelist>

<para>Any nonzero value other than the above will generate
the default number format (upperroman).
</para>


</refsect1>
</doc:refentry>
<xsl:param name="part.autolabel" select="'I'"/>

<doc:refentry><refmeta>
<refentrytitle>preface.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>preface.autolabel</refname>
<refpurpose>Specifices the labeling format for Preface titles</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If zero (default), then prefaces will not be numbered.
Otherwise prefaces will be numbered, using the parameter value
as the number format if the value matches one of the following:
</para>

<variablelist>
  <varlistentry>
    <term>1 or arabic</term>
    <listitem>
      <para>Arabic numeration (1, 2, 3 ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>A or upperalpha</term>
    <listitem>
      <para>Uppercase letter numeration (A, B, C ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>a or loweralpha</term>
    <listitem>
      <para>Lowercase letter numeration (a, b, c ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>I or upperroman</term>
    <listitem>
      <para>Uppercase roman numeration (I, II, III ...).</para>
    </listitem>
  </varlistentry>
  <varlistentry>
    <term>i or lowerroman</term>
    <listitem>
      <para>Lowercase roman letter numeration (i, ii, iii ...).</para>
    </listitem>
  </varlistentry>
</variablelist>

<para>Any nonzero value other than the above will generate
the default number format (arabic).
</para>


</refsect1>
</doc:refentry>
<xsl:param name="preface.autolabel" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>qandadiv.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>qandadiv.autolabel</refname>
<refpurpose>Are divisions in QAndASets enumerated?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), unlabeled qandadivs will be enumerated.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="qandadiv.autolabel" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>section.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>section.autolabel</refname>
<refpurpose>Are sections enumerated?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), unlabeled sections will be enumerated.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="section.autolabel" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>section.autolabel.max.depth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>section.autolabel.max.depth</refname>
<refpurpose>The deepest level of sections that are numbered.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When section numbering is turned on by the
<literal>section.autolabel</literal> parameter,
then this parameter controls the depth of section nesting
that is numbered.
Sections nested to a level deeper than this value will
not be numbered.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="section.autolabel.max.depth" select="8"/>

<doc:refentry><refmeta>
<refentrytitle>section.label.includes.component.label</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>section.label.includes.component.label</refname>
<refpurpose>Do section labels include the component label?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), section labels are prefixed with the label of the
component that contains them.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="section.label.includes.component.label" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>label.from.part</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>label.from.part</refname>
<refpurpose>Renumber chapters in each part?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>label.from.part</parameter> is non-zero, components
(<sgmltag>chapter</sgmltag>s, <sgmltag>appendixe</sgmltag>s, etc.)
will be numbered from 1 in each <sgmltag>part</sgmltag>. Otherwise,
they will be numbered monotonically throughout each
<sgmltag>book</sgmltag>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="label.from.part" select="'0'"/>

<doc:refentry><refmeta>
<refentrytitle>component.label.includes.part.label</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>component.label.includes.part.label</refname>
<refpurpose>Do component labels include the part label?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), number labels for chapters, appendices, and other component
elements are prefixed with the label of the
part element that contains them.
So you might see Chapter II.3 instead of Chapter 3.
Also, the labels for formal elements such as table and figure will
include the part label.
If there is no part element container, then no prefix is generated.
</para>
<para>
This feature is most useful when the
<literal>label.from.part</literal> parameter is turned on.
In that case, there would be more than one chapter
<quote>1</quote>, and the extra part label prefix will identify
each chapter unambiguously.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="component.label.includes.part.label" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>html.base</refentrytitle>
<refmiscinfo role="type">uri</refmiscinfo>
</refmeta><refnamediv>
<refname>html.base</refname>
<refpurpose>An HTML base URI</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If html.base is set, it is used for the <sgmltag>BASE</sgmltag>
element in the <sgmltag>HEAD</sgmltag> of the HTML documents.
This is useful for dynamically served HTML where the base URI needs
to be shifted.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.base"/>

<doc:refentry><refmeta>
<refentrytitle>html.stylesheet.type</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>html.stylesheet.type</refname>
<refpurpose>The type of the stylesheet used in the generated HTML</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The type of the stylesheet to place in the HTML <sgmltag>link</sgmltag> tag.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.stylesheet.type">text/css</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>html.stylesheet</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>html.stylesheet</refname>
<refpurpose>Name of the stylesheet(s) to use in the generated HTML</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>html.stylesheet</parameter> parameter is either empty,
indicating that no stylesheet <sgmltag>LINK</sgmltag> tag should be generated
in the HTML output, or it is a list of one or more stylesheets.</para>

<para>Multiple stylesheets are space-delimited. If you need to
reference a stylesheet URI that includes a space, encode it with
<literal>%20</literal>. A seprate HTML <sgmltag>LINK</sgmltag> element will
be generated for each stylesheet in the order they are listed in the
parameter.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.stylesheet" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>css.decoration</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>css.decoration</refname>
<refpurpose>Enable CSS decoration of elements</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If <literal>css.decoration</literal> is turned on, then HTML elements
produced by the
stylesheet may be decorated with STYLE attributes.  For example, the
LI tags produced for list items may include a fragment of CSS in the
STYLE attribute which sets the CSS property "list-style-type".
</para>

</refsect1>
</doc:refentry>
<xsl:param name="css.decoration" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>spacing.paras</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>spacing.paras</refname>
<refpurpose>Insert additional &lt;p&gt; elements for spacing?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When non-zero, additional, empty paragraphs are inserted in
several contexts (for example, around informal figures), to create a
more pleasing visual appearance in many browsers.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="spacing.paras" select="'0'"/>

<doc:refentry><refmeta>
<refentrytitle>emphasis.propagates.style</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>emphasis.propagates.style</refname>
<refpurpose>Pass emphasis role attribute through to HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, the role attribute of <sgmltag>emphasis</sgmltag> elements
will be passed through to the HTML as a class attribute on a
<sgmltag>span</sgmltag> that surrounds the emphasis.</para>

</refsect1>
</doc:refentry>
<xsl:param name="emphasis.propagates.style" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>para.propagates.style</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>para.propagates.style</refname>
<refpurpose>Pass para role attribute through to HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, the role attribute of <sgmltag>para</sgmltag> elements
will be passed through to the HTML as a class attribute on the
<sgmltag>p</sgmltag> generated for the paragraph.</para>

</refsect1>
</doc:refentry>
<xsl:param name="para.propagates.style" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>phrase.propagates.style</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>phrase.propagates.style</refname>
<refpurpose>Pass phrase role attribute through to HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, the role attribute of <sgmltag>phrase</sgmltag> elements
will be passed through to the HTML as a class attribute on a
<sgmltag>span</sgmltag> that surrounds the phrase.</para>

</refsect1>
</doc:refentry>
<xsl:param name="phrase.propagates.style" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>entry.propagates.style</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>entry.propagates.style</refname>
<refpurpose>Pass entry role attribute through to HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, the role attribute of <sgmltag>entry</sgmltag> elements
will be passed through to the HTML as a class attribute on the
<sgmltag>td</sgmltag> or <sgmltag>th</sgmltag> generated for the table
cell.</para>

</refsect1>
</doc:refentry>
<xsl:param name="entry.propagates.style" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>html.longdesc</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>html.longdesc</refname>
<refpurpose>Should longdesc URIs be created?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, HTML files will be created for the
<sgmltag class="attribute">longdesc</sgmltag> attribute. These files
are created from the <sgmltag>textobject</sgmltag>s in
<sgmltag>mediaobject</sgmltag>s and
<sgmltag>inlinemediaobject</sgmltag>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.longdesc" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>html.longdesc.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>html.longdesc.link</refname>
<refpurpose>Should a link to the longdesc be included in the HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, links will be created to the
HTML files created for the
<sgmltag class="attribute">longdesc</sgmltag> attribute. It makes no
sense to turn enable this option without also enabling the
<parameter>$html.longdesc</parameter> parameter.</para>

<para>The <literal>longdesc.link</literal> named template is called
to construct the link.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.longdesc.link" select="$html.longdesc"/>

<doc:refentry><refmeta>
<refentrytitle>make.valid.html</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>make.valid.html</refname>
<refpurpose>Attempt to make sure the HTML output is valid HTML</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>make.valid.html</parameter> is true, the stylesheets take
extra effort to ensure that the resulting HTML is valid. This may mean that some
<sgmltag>para</sgmltag> tags are translated into HTML <sgmltag>div</sgmltag>s or
that other substitutions occur.</para>

<para>This parameter is different from <parameter>html.cleanup</parameter>
because it changes the resulting markup; it does not use extension functions
to manipulate result-tree-fragments and is therefore applicable to any
XSLT processor.</para>

</refsect1>
</doc:refentry>
<xsl:param name="make.valid.html" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>html.cleanup</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>html.cleanup</refname>
<refpurpose>Attempt to clean up the resulting HTML?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, and if the <ulink url="http://www.exslt.org/">EXSLT</ulink>
extensions are supported by your processor, the resulting HTML will be
<quote>cleaned up</quote>. This improves the chances that the
resulting HTML will be valid. It may also improve the formatting of
some elements.</para>

<para>This parameter is different from <parameter>make.valid.html</parameter>
because it uses extension functions to manipulate result-tree-fragments.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.cleanup" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>draft.mode</refentrytitle>
<refmiscinfo role="type">list</refmiscinfo>
</refmeta><refnamediv>
<refname>draft.mode</refname>
<refpurpose>Select draft mode</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Selects draft mode. If <parameter>draft.mode</parameter> is
<quote><literal>yes</literal></quote>, the entire document will be treated
as a draft. If it is <quote><literal>no</literal></quote>, the entire document
will be treated as a final copy. If it is <quote><literal>maybe</literal></quote>,
individual sections will be treated as draft or final independently, depending
on how their <sgmltag class="attribute">status</sgmltag> attribute is set.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="draft.mode" select="'maybe'"/>

<doc:refentry><refmeta>
<refentrytitle>draft.watermark.image</refentrytitle>
<refmiscinfo role="type">uri</refmiscinfo>
</refmeta><refnamediv>
<refname>draft.watermark.image</refname>
<refpurpose>The URI of the image to be used for draft watermarks</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The image to be used for draft watermarks.</para>

</refsect1>
</doc:refentry>
<xsl:param name="draft.watermark.image" select="'http://docbook.sourceforge.net/release/images/draft.png'"/>

<doc:refentry><refmeta>
<refentrytitle>generate.id.attributes</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>generate.id.attributes</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the HTML stylesheet will generate ID attributes on
containers. For example, the markup:</para>

<screen>&lt;section id="foo"&gt;&lt;title&gt;Some Title&lt;/title&gt;
&lt;para&gt;Some para.&lt;/para&gt;
&lt;/section&gt;</screen>

<para>might produce:</para>

<screen>&lt;div class="section" id="foo"&gt;
&lt;h2&gt;Some Title&lt;/h2&gt;
&lt;p&gt;Some para.&lt;/p&gt;
&lt;/div&gt;</screen>

<para>The alternative is to generate anchors:</para>

<screen>&lt;div class="section"&gt;
&lt;h2&gt;&lt;a name="foo"&gt;&lt;/a&gt;Some Title&lt;/h2&gt;
&lt;p&gt;Some para.&lt;/p&gt;
&lt;/div&gt;</screen>

<para>Because the <sgmltag class="attribute">name</sgmltag> attribute of
the <sgmltag>a</sgmltag> element and the <sgmltag class="attribute">id</sgmltag>
attribute of other tags are both of type <quote>ID</quote>, producing both
generates invalid documents.</para>

<para>As of version 1.50, you can use this switch to control which type of
identifier is generated. For backwards-compatibility, generating
<sgmltag>a</sgmltag> anchors is preferred.</para>

<para>Note: at present, this switch is incompletely implemented.
Disabling ID attributes will suppress them, but enabling ID attributes
will not suppress the anchors.</para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.id.attributes" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>generate.meta.abstract</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.meta.abstract</refname>
<refpurpose>Generate HTML <sgmltag>META</sgmltag> element from <sgmltag>abstract</sgmltag>?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, document abstracts will be reproduced in the HTML
<sgmltag>HEAD</sgmltag> with <sgmltag class="starttag">meta name="description" content="..."</sgmltag>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.meta.abstract" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>rootid</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>rootid</refname>
<refpurpose>Specify the root element to format</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>rootid</parameter> is specified, it must be the
value of an ID that occurs in the document being formatted. The entire
document will be loaded and parsed, but formatting will begin at the
element identified, rather than at the root. For example, this allows
you to process only chapter 4 of a book.</para>
<para>Because the entire document is available to the processor, automatic
numbering, cross references, and other dependencies are correctly
resolved.</para>

</refsect1>
</doc:refentry>
<xsl:param name="rootid" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>suppress.navigation</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>suppress.navigation</refname>
<refpurpose>Disable header and footer navigation</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If <literal>suppress.navigation</literal> is turned on, header and
footer navigation will be suppressed.</para>

</refsect1>
</doc:refentry>
<xsl:param name="suppress.navigation">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>suppress.header.navigation</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>suppress.header.navigation</refname>
<refpurpose>Disable header navigation</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If <literal>suppress.header.navigation</literal> is turned on, header
navigation will be suppressed.</para>

</refsect1>
</doc:refentry>
<xsl:param name="suppress.header.navigation">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>suppress.footer.navigation</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>suppress.footer.navigation</refname>
<refpurpose>Disable footer navigation</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If <literal>suppress.footer.navigation</literal> is turned on, footer
navigation will be suppressed.</para>

</refsect1>
</doc:refentry>
<xsl:param name="suppress.footer.navigation">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>header.rule</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>header.rule</refname>
<refpurpose>Rule under headers?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, a rule will be drawn below the page headers.</para>

</refsect1>
</doc:refentry>
<xsl:param name="header.rule" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>footer.rule</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>footer.rule</refname>
<refpurpose>Rule over footers?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, a rule will be drawn above the page footers.</para>

</refsect1>
</doc:refentry>
<xsl:param name="footer.rule" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>id.warnings</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>id.warnings</refname>
<refpurpose>Should warnings be generated for titled elements without IDs?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the stylesheet will issue a warning for
any element (other than the root element) which
has a title but does not have an ID.</para>

</refsect1>
</doc:refentry>
<xsl:param name="id.warnings" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>inherit.keywords</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>inherit.keywords</refname>
<refpurpose>Inherit keywords from ancestor elements?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>inherit.keywords</parameter>
is non-zero, the keyword <sgmltag>META</sgmltag> for each HTML
<sgmltag>HEAD</sgmltag> element will include all of the keywords from
ancestral elements. Otherwise, only the keywords from the current section
will be used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="inherit.keywords" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>make.single.year.ranges</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>make.single.year.ranges</refname>
<refpurpose>Print single-year ranges (e.g., 1998-1999)</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, year ranges that span a single year will be printed
in range notation (1998-1999) instead of discrete notation
(1998, 1999).</para>

</refsect1>
</doc:refentry>
<xsl:param name="make.single.year.ranges" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>make.year.ranges</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>make.year.ranges</refname>
<refpurpose>Collate copyright years into ranges?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, copyright years will be collated into ranges.</para>

</refsect1>
</doc:refentry>
<xsl:param name="make.year.ranges" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>author.othername.in.middle</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>author.othername.in.middle</refname>
<refpurpose>Is <sgmltag>othername</sgmltag> in <sgmltag>author</sgmltag> a
middle name?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), the <sgmltag>othername</sgmltag> of an <sgmltag>author</sgmltag>
appears between the <sgmltag>firstname</sgmltag> and
<sgmltag>surname</sgmltag>.  Otherwise, <sgmltag>othername</sgmltag>
is suppressed.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="author.othername.in.middle" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>generate.legalnotice.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.legalnotice.link</refname>
<refpurpose>Write legalnotice to separate chunk and generate link?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If the value of <parameter>generate.legalnotice.link</parameter>
is non-zero, the stylesheet:

<itemizedlist>
  <listitem>
    <para>writes the contents of <tag>legalnotice</tag> to a separate
    HTML file</para>
  </listitem>
  <listitem>
    <para>inserts a hyperlink to the <tag>legalnotice</tag> file</para>
  </listitem>
  <listitem>
    <para>adds (in the HTML <literal>head</literal>) either a single
    <literal>link</literal> or element or multiple
    <literal>link</literal> elements (depending on the value of the
    <parameter>html.head.legalnotice.link.multiple</parameter>
    parameter), with the value or values derived from the
    <parameter>html.head.legalnotice.link.types</parameter>
    parameter</para>
  </listitem>
  </itemizedlist>

  Otherwise, if <parameter>generate.legalnotice.link</parameter> is
  zero, <tag>legalnotice</tag> contents are rendered on the title
  page.</para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.legalnotice.link" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>generate.revhistory.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>generate.revhistory.link</refname>
<refpurpose>Write revhistory to separate chunk and generate link?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the contents of <tag>revhistory</tag> are written
to a separate HTML file and a link to the file is
generated. Otherwise, <tag>revhistory</tag> contents are rendered on
the title page.</para>

</refsect1>
</doc:refentry>
<xsl:param name="generate.revhistory.link" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>html.head.legalnotice.link.types</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>html.head.legalnotice.link.types</refname>
<refpurpose>Specifies link types for legalnotice link in html head</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The value of
<parameter>html.head.legalnotice.link.types</parameter> is a
space-separated list of link types, as described in <ulink url="http://www.w3.org/TR/html401/types.html#type-links">Section 6.12
of the HTML 4.01 specification</ulink>. If the value of the
<parameter>generate.legalnotice.link</parameter> parameter is
non-zero, then the stylesheet generates (in the
<literal>head</literal> section of the HTML source) either a single
HTML <literal>link</literal> element or, if the value of the
<parameter>html.head.legalnotice.link.multiple</parameter> is
non-zero, one <literal>link</literal> element for each link type
specified. Each <literal>link</literal> has the following attributes:

<itemizedlist>
  <listitem>
    <para>a <sgmltag class="attribute">rel</sgmltag> attribute whose
    value is derived from the value of
    <parameter>html.head.legalnotice.link.types</parameter></para>
  </listitem>
  <listitem>
    <para>an <sgmltag class="attribute">href</sgmltag> attribute whose
    value is set to the URL of the file containing the
    <sgmltag>legalnotice</sgmltag></para>
  </listitem>
  <listitem>
    <para>a <sgmltag class="attribute">title</sgmltag> attribute whose
    value is set to the title of the corresponding
    <sgmltag>legalnotice</sgmltag> (or a title programatically
    determined by the stylesheet)</para>
  </listitem>
</itemizedlist>

For example:

<screen>  &lt;link rel="license" href="ln-id2524073.html" title="Legal Notice"&gt;</screen>
</para>

<refsect2>
  <title>About the default value</title>
  <para>In an ideal world, the default value of
  <parameter>html.head.legalnotice.link.types</parameter> would
  probably be “<literal>license</literal>”, since the content of the
  DocBook <sgmltag>legalnotice</sgmltag> is typically license
  information, not copyright information. However, the default value
  is “<literal>copyright</literal>” for pragmatic reasons: because
  that’s among the set of “recognized link types” listed in <ulink url="http://www.w3.org/TR/html401/types.html#type-links">Section
  6.12 of the HTML 4.01 specification</ulink>, and because certain
  browsers and browser extensions are preconfigured to recognize that
  value.</para>
</refsect2>

</refsect1>
</doc:refentry>
<xsl:param name="html.head.legalnotice.link.types">copyright</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>html.head.legalnotice.link.multiple</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>html.head.legalnotice.link.multiple</refname>
<refpurpose>Generate multiple link instances in html head for legalnotice?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>html.head.legalnotice.link.multiple</parameter> is
non-zero and the value of
<parameter>html.head.legalnotice.link.types</parameter> contains
multiple link types, then the stylesheet generates (in the
<literal>head</literal> section of the HTML source) one
<literal>link</literal> element for each link type specified. For
example, if the value of
<parameter>html.head.legalnotice.link.types</parameter> is
“<literal>copyright license</literal>”:

<screen>  &lt;link rel="copyright" href="ln-id2524073.html" title="Legal Notice"&gt;
  &lt;link rel="license" href="ln-id2524073.html" title="Legal Notice"&gt;</screen>

 Otherwise, the stylesheet generates generates a single
 <literal>link</literal> instance; for example:

<screen>  &lt;link rel="copyright license" href="ln-id2524073.html" title="Legal Notice"&gt;</screen>
 
</para>
</refsect1>
</doc:refentry>
<xsl:param name="html.head.legalnotice.link.multiple" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>funcsynopsis.decoration</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>funcsynopsis.decoration</refname>
<refpurpose>Decorate elements of a FuncSynopsis?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), elements of the FuncSynopsis will be decorated (e.g. bold or
italic).  The decoration is controlled by functions that can be redefined
in a customization layer.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="funcsynopsis.decoration" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>funcsynopsis.style</refentrytitle>
<refmiscinfo role="type">list</refmiscinfo>
<refmiscinfo role="value">ansi</refmiscinfo>
<refmiscinfo role="value">kr</refmiscinfo>
</refmeta><refnamediv>
<refname>funcsynopsis.style</refname>
<refpurpose>What style of 'FuncSynopsis' should be generated?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <varname>funcsynopsis.style</varname> is <literal>ansi</literal>,
ANSI-style function synopses are generated for a
<sgmltag>funcsynopsis</sgmltag>, otherwise K&amp;R-style
function synopses are generated.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="funcsynopsis.style">kr</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>funcsynopsis.tabular.threshold</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>funcsynopsis.tabular.threshold</refname>
<refpurpose>Width beyond which a tabular presentation will be used</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>funcsynopsis.tabular.threshold</parameter> is greater than
zero then if a <sgmltag>funcprototype</sgmltag> is wider than the threshold
value, it will be presented in a table.</para>

</refsect1>
</doc:refentry>
<xsl:param name="funcsynopsis.tabular.threshold" select="40"/>

<doc:refentry><refmeta>
<refentrytitle>function.parens</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>function.parens</refname>
<refpurpose>Generate parens after a function?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If not 0, the formatting of
a <sgmltag class="starttag">function</sgmltag> element will include
generated parenthesis.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="function.parens">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>refentry.generate.name</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>refentry.generate.name</refname>
<refpurpose>Output NAME header before 'RefName'(s)?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), a "NAME" section title is output before the list
of 'RefName's. This parameter and
<parameter>refentry.generate.title</parameter> are mutually
exclusive. This means that if you change this parameter to zero, you
should set <parameter>refentry.generate.title</parameter> to 1 unless
you want get quite strange output.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="refentry.generate.name" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>refentry.generate.title</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>refentry.generate.title</refname>
<refpurpose>Output title before 'RefName'(s)?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), the reference page title or first name is
output before the list of 'RefName's. This parameter and
<parameter>refentry.generate.name</parameter> are mutually exclusive.
This means that if you change this parameter to 1, you
should set <parameter>refentry.generate.name</parameter> to 0 unless
you want get quite strange output.</para>


</refsect1>
</doc:refentry>
<xsl:param name="refentry.generate.title" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>refentry.xref.manvolnum</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>refentry.xref.manvolnum</refname>
<refpurpose>Output <sgmltag>manvolnum</sgmltag> as part of 
<sgmltag>refentry</sgmltag> cross-reference?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>if true (non-zero), the <sgmltag>manvolnum</sgmltag> is used when cross-referencing
<sgmltag>refentry</sgmltag>s, either with <sgmltag>xref</sgmltag>
or <sgmltag>citerefentry</sgmltag>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="refentry.xref.manvolnum" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>citerefentry.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>citerefentry.link</refname>
<refpurpose>Generate URL links when cross-referencing RefEntrys?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, a web link will be generated, presumably
to an online man-&gt;HTML gateway. The text of the link is
generated by the generate.citerefentry.link template.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="citerefentry.link" select="'0'"/>

<doc:refentry><refmeta>
<refentrytitle>refentry.separator</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>refentry.separator</refname>
<refpurpose>Generate a separator between consecutive RefEntry elements?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, a separator will be generated between consecutive
reference pages.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="refentry.separator" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>refclass.suppress</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>refclass.suppress</refname>
<refpurpose>Suppress display of refclass contents?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If the value of <parameter>refclass.suppress</parameter> is
non-zero, then display of <sgmltag>refclass</sgmltag> contents is
suppressed in output.</para>

</refsect1>
</doc:refentry>
<xsl:param name="refclass.suppress" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>default.table.width</refentrytitle>
<refmiscinfo role="type">length</refmiscinfo>
</refmeta><refnamediv>
<refname>default.table.width</refname>
<refpurpose>The default width of tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If specified, this value will be used for the WIDTH attribute on
tables that do not specify an alternate width (with the dbhtml processing
instruction).</para>

</refsect1>
</doc:refentry>
<xsl:param name="default.table.width" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>nominal.table.width</refentrytitle>
<refmiscinfo role="type">length</refmiscinfo>
</refmeta><refnamediv>
<refname>nominal.table.width</refname>
<refpurpose>The (absolute) nominal width of tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>In order to convert CALS column widths into HTML column widths, it
is sometimes necessary to have an absolute table width to use for conversion
of mixed absolute and relative widths. This value must be an absolute
length (not a percentag).</para>

</refsect1>
</doc:refentry>
<xsl:param name="nominal.table.width" select="'6in'"/>

<doc:refentry><refmeta>
<refentrytitle>table.borders.with.css</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>table.borders.with.css</refname>
<refpurpose>Use CSS to specify table, row, and cell borders?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), CSS will be used to draw table borders.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.borders.with.css" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>table.cell.border.style</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.cell.border.style</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.cell.border.style" select="'solid'"/>

<doc:refentry><refmeta>
<refentrytitle>table.cell.border.thickness</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.cell.border.thickness</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.cell.border.thickness" select="'0.5pt'"/>

<doc:refentry><refmeta>
<refentrytitle>table.cell.border.color</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.cell.border.color</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.cell.border.color" select="''"/>


<doc:refentry><refmeta>
<refentrytitle>table.frame.border.style</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.frame.border.style</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.frame.border.style" select="'solid'"/>

<doc:refentry><refmeta>
<refentrytitle>table.frame.border.thickness</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.frame.border.thickness</refname>
<refpurpose>Specifies the thickness of the frame border</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies the thickness of the border on the table's frame.</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.frame.border.thickness" select="'0.5pt'"/>

<doc:refentry><refmeta>
<refentrytitle>table.frame.border.color</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.frame.border.color</refname>
<refpurpose/>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.frame.border.color" select="''"/>


<doc:refentry><refmeta>
<refentrytitle>default.table.frame</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>default.table.frame</refname>
<refpurpose>The default framing of tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This value will be used when there is no frame attribute on the table.</para>

</refsect1>
</doc:refentry>
<xsl:param name="default.table.frame" select="'all'"/>

<doc:refentry><refmeta>
<refentrytitle>html.cellspacing</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>html.cellspacing</refname>
<refpurpose>Default value for cellspacing in HTML tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If specified, this value will be used as the default cellspacing value
in HTML tables.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.cellspacing" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>html.cellpadding</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>html.cellpadding</refname>
<refpurpose>Default value for cellpadding in HTML tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If specified, this value will be used as the default cellpadding value
in HTML tables.</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.cellpadding" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>qanda.defaultlabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>qanda.defaultlabel</refname>
<refpurpose>Sets the default for defaultlabel on QandASet.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If no defaultlabel attribute is specified on a QandASet, this
value is used. It must be one of the legal values for the defaultlabel
attribute.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="qanda.defaultlabel">number</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>qanda.inherit.numeration</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>qanda.inherit.numeration</refname>
<refpurpose>Does enumeration of QandASet components inherit the numeration of parent elements?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), numbered QandADiv elements and Questions and Answers inherit
the numeration of the ancestors of the QandASet.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="qanda.inherit.numeration" select="1"/>

<doc:refentry><refmeta> 
<refentrytitle>target.database.document</refentrytitle> 
<refmiscinfo role="type">uri</refmiscinfo> 
</refmeta><refnamediv> 
<refname>target.database.document</refname> 
<refpurpose>Name of master database file for resolving
olinks</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1>
<title>Description</title> 
<para>
To resolve olinks between documents, the stylesheets use
a master database document that identifies the  target datafiles for all the documents within the scope
of the olinks. This parameter value is the URI of 
the master document to be read during processing to resolve olinks.
The default value is <filename>olinkdb.xml</filename>.</para>
<para>The data structure of the file is defined in the <filename>targetdatabase.dtd</filename> DTD.  The database file provides the high level elements to record the identifiers, locations, and relationships of documents. The cross reference data for individual documents is generally pulled into the database using system entity references or XIncludes. See also <parameter>targets.filename</parameter>.

</para> 
</refsect1>
</doc:refentry>
<xsl:param name="target.database.document" select="''"/>

<doc:refentry><refmeta> 
<refentrytitle>targets.filename</refentrytitle> 
<refmiscinfo role="type">string</refmiscinfo> 
</refmeta><refnamediv> 
<refname>targets.filename</refname> 
<refpurpose>Name of cross reference targets data file</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1>
<title>Description</title> 
<para>
In order to resolve olinks efficiently, the stylesheets can
generate an external data file containing information about
all potential cross reference endpoints in a document.
This parameter lets you change the name of the generated
file from the default name <filename>target.db</filename>.
The name must agree with that used in the target database
used to resolve olinks during processing.
See also <parameter>target.database.document</parameter>.
</para> 
</refsect1>
</doc:refentry>
<xsl:param name="targets.filename" select="'target.db'"/>

<doc:refentry><refmeta> 
<refentrytitle>olink.base.uri</refentrytitle> 
<refmiscinfo role="type">uri</refmiscinfo> 
</refmeta><refnamediv> 
<refname>olink.base.uri</refname> 
<refpurpose>Base URI used in olink hrefs</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 
<para>When cross reference data is collected for resolving olinks, it may be necessary to prepend a base URI to each target's href. This parameter lets you set that base URI when cross reference data is collected. This feature is needed when you want to link to a document that is processed without chunking. The output filename for such a document is not known to the XSL stylesheet; the only target information consists of fragment identifiers such as <literal>#idref</literal>. To enable the resolution of olinks between documents, you should pass the name of the HTML output file as the value of this parameter. Then the hrefs recorded in the cross reference data collection look like <literal>outfile.html#idref</literal>, which can  be reached as links from other documents.</para> 
</refsect1>
</doc:refentry>
<xsl:param name="olink.base.uri" select="''"/> 

<doc:refentry><refmeta> 
<refentrytitle>use.local.olink.style</refentrytitle> 
<refmiscinfo role="type">boolean</refmiscinfo> 
</refmeta><refnamediv> 
<refname>use.local.olink.style</refname> 
<refpurpose>Process olinks using xref style of current
document</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 
<para>When cross reference data is collected for use by olinks, the data for each potential target includes one field containing a completely assembled cross reference string, as if it were an xref generated in that document. Other fields record the separate title, number, and element name of each target. When an olink is formed to a target from another document, the olink resolves to that preassembled string by default. If the <parameter>use.local.olink.style</parameter> parameter is set to non-zero, then instead the cross
reference string is formed again from the target title, number, and
element name, using the stylesheet processing the targeting document.
Then olinks will match the xref style in the targeting document
rather than in the target document. If  both documents are processed
with the same stylesheet, then the results will be the same.</para> 
</refsect1>
</doc:refentry>
<xsl:param name="use.local.olink.style" select="0"/> 

<doc:refentry><refmeta> 
<refentrytitle>current.docid</refentrytitle> 
<refmiscinfo role="type">string</refmiscinfo> 
</refmeta><refnamediv> 
<refname>current.docid</refname> 
<refpurpose>targetdoc identifier for the document being
processed</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 
<para>When olinks between documents are resolved for HTML output, the stylesheet can compute the relative path between the current document and the target document. The stylesheet needs to know the <literal>targetdoc</literal> identifiers for both documents, as they appear in the <parameter>target.database.document</parameter> database file. This parameter passes to the stylesheet
the targetdoc identifier of the current document, since that
identifier does not appear in the document itself. </para>
<para>This parameter can also be used for print output. If an olink's  <literal>targetdoc</literal>  id differs from the <literal>current.docid</literal>, then the stylesheet can append the target document's title to the generated olink text. That identifies to the reader that the link is to a different document, not the current document. See also <parameter>olink.doctitle</parameter> to enable that feature.</para> 
</refsect1>
</doc:refentry>
<xsl:param name="current.docid" select="''"/> 

<doc:refentry><refmeta> 
<refentrytitle>olink.doctitle</refentrytitle> 
<refmiscinfo role="type">string</refmiscinfo> 
</refmeta><refnamediv> 
<refname>olink.doctitle</refname> 
<refpurpose>show the document title for external olinks?</refpurpose>

</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 
<para>When olinks between documents are resolved, the generated text
may not make it clear that the reference is to another document.
It is possible for the stylesheets to append the other document's
title to external olinks. For this to happen, two parameters must
be set.</para>
<itemizedlist>
<listitem>
<para>This <parameter>olink.doctitle</parameter> parameter
should be set to either <literal>yes</literal> or <literal>maybe</literal>
to enable this feature.
</para>
</listitem>
<listitem>
<para>And you should also set the <parameter>current.docid</parameter>
parameter to the document id for the  document currently
being processed for output.
</para>
</listitem>
</itemizedlist>

<para>
Then if an olink's  <literal>targetdoc</literal> id differs from
the <literal>current.docid</literal> value, the stylesheet knows
that it is a reference to another document and can
append the target document's
title to the generated olink text. </para> 

<para>The text for the target document's title is copied from the
olink database from the <sgmltag>ttl</sgmltag> element
of the top-level <sgmltag>div</sgmltag> for that document.
If that <sgmltag>ttl</sgmltag> element is missing or empty,
no title is output.
</para>

<para>The supported values for <parameter>olink.doctitle</parameter> are:
</para>
<variablelist>
<varlistentry>
<term><literal>yes</literal></term>
<listitem>
<para>
Always insert the title to the target document if it is not
the current document.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>no</literal></term>
<listitem>
<para>
Never insert the title to the target document, even if requested
in an <sgmltag class="attribute">xrefstyle</sgmltag> attribute.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>maybe</literal></term>
<listitem>
<para>
Only insert the title to the target document, if requested
in an <sgmltag class="attribute">xrefstyle</sgmltag> attribute.
</para>
</listitem>
</varlistentry>
</variablelist>
<para>An <sgmltag class="attribute">xrefstyle</sgmltag> attribute
may override the global setting for individual olinks.
The following values are supported in an
<sgmltag class="attribute">xrefstyle</sgmltag>
attribute using the <literal>select:</literal> syntax:
</para>

<variablelist>
<varlistentry>
<term><literal>docname</literal></term>
<listitem>
<para>
Insert the target document name for this olink using the
<literal>docname</literal> gentext template, but only
if the value of <parameter>olink.doctitle</parameter>
is not <literal>no</literal>.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>docnamelong</literal></term>
<listitem>
<para>
Insert the target document name for this olink using the
<literal>docnamelong</literal> gentext template, but only
if the value of <parameter>olink.doctitle</parameter>
is not <literal>no</literal>.
</para>
</listitem>
</varlistentry>
<varlistentry>
<term><literal>nodocname</literal></term>
<listitem>
<para>
Omit the target document name even if
the value of <parameter>olink.doctitle</parameter>
is <literal>yes</literal>.
</para>
</listitem>
</varlistentry>
</variablelist>
<para>Another way of inserting the target document name 
for a single olink is to employ an
<sgmltag class="attribute">xrefstyle</sgmltag>
attribute using the <literal>template:</literal> syntax.
The <literal>%o</literal> placeholder (the letter o, not zero)
in such a template
will be filled in with the target document's title when it is processed.
This will occur regardless of 
the value of <parameter>olink.doctitle</parameter>.
</para>
<para>Note that prior to version 1.66 of the XSL stylesheets,
the allowed values for this parameter were 0 and 1.  Those
values are still supported and mapped to 'no' and 'yes', respectively.
</para>
</refsect1>
</doc:refentry>
<xsl:param name="olink.doctitle" select="'no'"/> 

<doc:refentry><refmeta>
<refentrytitle>olink.debug</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>olink.debug</refname>
<refpurpose>Turn on debugging messages for olinks</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, then each olink will generate several
messages about how it is being resolved during processing.
This is useful when an olink does not resolve properly
and the standard error messages are not sufficient to
find the problem. 
</para>

<para>You may need to read through the olink XSL templates
to understand the context for some of the debug messages.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.debug" select="0"/>

<doc:refentry><refnamediv>
<refname>olink.properties</refname>
<refpurpose>Properties associated with the cross-reference 
text of an olink.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This attribute set is used on cross reference text
from an olink. It is not applied to the
optional page number or 
optional title of the external document.</para>

</refsect1>
</doc:refentry>
<xsl:attribute-set name="olink.properties">
</xsl:attribute-set>

<doc:refentry><refmeta> 
<refentrytitle>olink.lang.fallback.sequence</refentrytitle> 
<refmiscinfo role="type">string</refmiscinfo> 
</refmeta><refnamediv> 
<refname>olink.lang.fallback.sequence</refname> 
<refpurpose>look up translated documents if olink not found?</refpurpose>

</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 

<para>This parameter defines a list of lang values
to search among to resolve olinks.
</para>

<para>Normally an olink tries to resolve to a document in the same
language as the olink itself.  The language of an olink
is determined by its nearest ancestor element with a
<sgmltag class="attribute">lang</sgmltag> attribute, otherwise the
value of the <parameter>l10n.gentext.default.lang</parameter>
parameter.
</para>

<para>An olink database can contain target data for the same
document in multiple languages.  Each set of data has the
same value for the <sgmltag>targetdoc</sgmltag> attribute in
the <sgmltag>document</sgmltag> element in the database, but with a 
different <sgmltag>lang</sgmltag> attribute value.
</para>

<para>When an olink is being resolved, the target is first
sought in the document with the same language as the olink.
If no match is found there, then this parameter is consulted
for additional languages to try.</para>

<para>The <parameter>olink.lang.fallback.sequence</parameter>
must be a whitespace separated list of lang values to
try.  The first one with a match in the olink database is used.
The default value is empty.</para>

<para>For example, a document might be written in German
and contain an olink with
<literal>targetdoc="adminguide"</literal>.
When the document is processed, the processor
first looks for a target dataset in the
olink database starting with:</para>

<literallayout><literal>&lt;document targetdoc="adminguide" lang="de"&gt;</literal>.
</literallayout>

<para>If there is no such element, then the
<parameter>olink.lang.fallback.sequence</parameter> 
parameter is consulted.
If its value is, for example, <quote>fr en</quote>, then the processor next
looks for <literal>targetdoc="adminguide" lang="fr"</literal>, and
then for <literal>targetdoc="adminguide" lang="en"</literal>.
If there is still no match, it looks for
<literal>targetdoc="adminguide"</literal> with no
lang attribute.
</para>

<para>This parameter is useful when a set of documents is only
partially translated, or is in the process of being translated.  
If a target of an olink has not yet been translated, then this
parameter permits the processor to look for the document in
other languages.  This assumes the reader would rather have
a link to a document in a different language than to have
a broken link.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.lang.fallback.sequence" select="''"/> 

<doc:refentry><refmeta>
<refentrytitle>insert.olink.page.number</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>insert.olink.page.number</refname>
<refpurpose>Turns page numbers in olinks on and off</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The value of this parameter determines if
cross references made between documents with
<sgmltag>olink</sgmltag> will 
include page number citations.
In most cases this is only applicable to references in printed output.
</para>
<para>The parameter has three possible values.
</para>
<variablelist>
<varlistentry>
<term>no</term>
<listitem><para>No page number references will be generated for olinks.
</para></listitem>
</varlistentry>
<varlistentry>
<term>yes</term>
<listitem><para>Page number references will be generated
for all <sgmltag>olink</sgmltag> references.
The style of page reference may be changed
if an <sgmltag class="attribute">xrefstyle</sgmltag>
attribute is used.
</para></listitem>
</varlistentry>
<varlistentry>
<term>maybe</term>
<listitem><para>Page number references will not be generated
for an <sgmltag>olink</sgmltag> element unless 
it has an
<sgmltag class="attribute">xrefstyle</sgmltag>
attribute whose value specifies a page reference.
</para></listitem>
</varlistentry>
</variablelist>
<para>Olinks that point to targets within the same document
are treated as <sgmltag>xref</sgmltag>s, and controlled by
the <parameter>insert.xref.page.number</parameter> parameter.
</para>

<para>Page number references for olinks to
external documents can only be inserted if the 
information exists in the olink database. 
This means each olink target element 
(<sgmltag>div</sgmltag> or <sgmltag>obj</sgmltag>)
must have a <sgmltag class="attribute">page</sgmltag> attribute
whose value is its page number in the target document.
The XSL stylesheets are not able to extract that information
during processing because pages have not yet been created in
XSLT transformation.  Only the XSL-FO processor knows what
page each element is placed on.
Therefore some postprocessing must take place to populate
page numbers in the olink database.
</para>



</refsect1>
</doc:refentry>
<xsl:param name="insert.olink.page.number">no</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>insert.olink.pdf.frag</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>insert.olink.pdf.frag</refname>
<refpurpose>Add fragment identifiers for links into PDF files</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The value of this parameter determines whether
the cross reference URIs to PDF documents made with
<sgmltag>olink</sgmltag> will 
include fragment identifiers.
</para>

<para>When forming a URI to link to a PDF document,
a fragment identifier (typically a '#' followed by an
id value) appended to the PDF filename can be used by
the PDF viewer to open
the PDF file to a location within the document instead of
the first page.
However, not all PDF files have id
values embedded in them, and not all PDF viewers can
handle fragment identifiers. 
</para>

<para>If <parameter>insert.olink.pdf.frag</parameter> is set
to a non-zero value, then any olink targeting a
PDF file will have the fragment identifier appended to the URI.
The URI is formed by concatenating the value of the
<parameter>olink.base.uri</parameter> parameter, the
value of the <sgmltag class="attribute">baseuri</sgmltag>
attribute from the <sgmltag class="element">document</sgmltag>
element in the olink database with the matching
<sgmltag class="attribute">targetdoc</sgmltag> value,
and the value of the <sgmltag class="attribute">href</sgmltag>
attribute for the targeted element in the olink database.
The <sgmltag class="attribute">href</sgmltag> attribute
contains the fragment identifier.
</para>

<para>If <parameter>insert.olink.pdf.frag</parameter> is set
to zero (the default value), then 
the <sgmltag class="attribute">href</sgmltag> attribute
from the olink database
is not appended to PDF olinks, so the fragment identifier is left off.
A PDF olink is any olink for which the
<sgmltag class="attribute">baseuri</sgmltag> attribute
from the matching <sgmltag class="element">document</sgmltag>
element in the olink database ends with '.pdf'.
Any other olinks will still have the fragment identifier added.
</para>
</refsect1>
</doc:refentry>
<xsl:param name="insert.olink.pdf.frag" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>prefer.internal.olink</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>prefer.internal.olink</refname>
<refpurpose>Prefer a local olink reference to an external reference</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you are re-using XML content modules in multiple documents,
you may want to redirect some of your olinks.  This parameter
permits you to redirect an olink to the current document.
</para>

<para>For example: you are writing documentation for a  product, 
which includes 3 manuals: a little installation
booklet (booklet.xml), a user 
guide (user.xml), and a reference manual (reference.xml).
All 3 documents begin with the same introduction section (intro.xml) that 
contains a reference to the customization section (custom.xml) which is 
included in both user.xml and reference.xml documents.
</para>

<para>How do you write the link to custom.xml in intro.xml
so that it is interpreted correctly in all 3 documents?</para>
<itemizedlist>
<listitem><para>If you use xref, it will fail in user.xml.</para>
</listitem>
<listitem><para>If you use olink (pointing to reference.xml),
the reference in user.xml  
will point to the customization section of the reference manual, while it is 
actually available in user.xml.</para>
</listitem>
</itemizedlist>

<para>If you set the <parameter>prefer.internal.olink</parameter>
parameter to a non-zero value, then the processor will
first look in the olink database
for the olink's <sgmltag>targetptr</sgmltag> attribute value
in document matching the <parameter>current.docid</parameter>
parameter value.  If it isn't found there, then
it tries the document in the database
with the <sgmltag>targetdoc</sgmltag>
value that matches the olink's <sgmltag>targetdoc</sgmltag>
attribute.
</para>

<para>This feature permits an olink reference to resolve to
the current document if there is an element
with an id matching the olink's <sgmltag>targetptr</sgmltag>
value.  The current document's olink data must be
included in the target database for this to work.</para>

<caution>
<para>There is a potential for incorrect links if
the same <sgmltag>id</sgmltag> attribute value is used for different
content in different documents.
Some of your olinks may be redirected to the current document
when they shouldn't be.  It is not possible to control
individual olink instances.</para>
</caution>

</refsect1>
</doc:refentry>
<xsl:param name="prefer.internal.olink" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>link.mailto.url</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>link.mailto.url</refname>
<refpurpose>Mailto URL for the LINK REL=made HTML HEAD element</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If not the empty string, this address will be used for the
REL=made <sgmltag>LINK</sgmltag> element in the HTML <sgmltag>HEAD</sgmltag>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="link.mailto.url"/>

<doc:refentry><refmeta>
<refentrytitle>ulink.target</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>ulink.target</refname>
<refpurpose>The HTML anchor target for ULinks</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>ulink.target</parameter> is set, its value will
be used for the <sgmltag class="attribute">target</sgmltag> attribute
on anchors generated for <sgmltag>ulink</sgmltag>s.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ulink.target" select="'_top'"/>

<doc:refentry><refmeta>
<refentrytitle>olink.fragid</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>olink.fragid</refname>
<refpurpose>Names the fragment identifier portion of an OLink resolver query</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.fragid" select="'fragid='"/>

<doc:refentry><refmeta>
<refentrytitle>olink.outline.ext</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>olink.outline.ext</refname>
<refpurpose>The extension of OLink outline files</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.outline.ext" select="'.olink'"/>

<doc:refentry><refmeta>
<refentrytitle>olink.pubid</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>olink.pubid</refname>
<refpurpose>Names the public identifier portion of an OLink resolver query</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.pubid" select="'pubid='"/>

<doc:refentry><refmeta>
<refentrytitle>olink.sysid</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>olink.sysid</refname>
<refpurpose>Names the system identifier portion of an OLink resolver query</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.sysid" select="'sysid='"/>

<doc:refentry><refmeta>
<refentrytitle>olink.resolver</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>olink.resolver</refname>
<refpurpose>The root name of the OLink resolver (usually a script)</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="olink.resolver" select="'/cgi-bin/olink'"/>

<doc:refentry><refmeta> 
<refentrytitle>collect.xref.targets</refentrytitle> 
<refmiscinfo role="type">string</refmiscinfo> 
</refmeta><refnamediv> 
<refname>collect.xref.targets</refname> 
<refpurpose>Controls whether cross reference data is
collected</refpurpose> 
</refnamediv><refsynopsisdiv>  
</refsynopsisdiv><refsect1> 
<title>Description</title> 
<para>
In order to resolve olinks efficiently, the stylesheets can
generate an external data file containing information about
all potential cross reference endpoints in a document.
This parameter determines whether the collection process is run when the document is processed by the stylesheet. The default value is  <literal>no</literal>, which means the data file is not generated during processing. The other choices are <literal>yes</literal>, which means the data file is created and the document is processed for output, and <literal>only</literal>, which means the data file is created but the document is not processed for output.
See also <parameter>targets.filename</parameter>.
</para> 
</refsect1>
</doc:refentry>
<xsl:param name="collect.xref.targets" select="'no'"/>

<doc:refentry><refmeta>
<refentrytitle>insert.xref.page.number</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>insert.xref.page.number</refname>
<refpurpose>Turns page numbers in xrefs on and off</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The value of this parameter determines if
cross references (<sgmltag>xref</sgmltag>s) in
printed output will
include page number citations.
It has three possible values.
</para>
<variablelist>
<varlistentry>
<term>no</term>
<listitem><para>No page number references will be generated.
</para></listitem>
</varlistentry>
<varlistentry>
<term>yes</term>
<listitem><para>Page number references will be generated
for all <sgmltag>xref</sgmltag> elements.
The style of page reference may be changed
if an <sgmltag class="attribute">xrefstyle</sgmltag>
attribute is used.
</para></listitem>
</varlistentry>
<varlistentry>
<term>maybe</term>
<listitem><para>Page number references will not be generated
for an <sgmltag>xref</sgmltag> element unless 
it has an
<sgmltag class="attribute">xrefstyle</sgmltag>
attribute whose value specifies a page reference.
</para></listitem>
</varlistentry>
</variablelist>

</refsect1>
</doc:refentry>
<xsl:param name="insert.xref.page.number">no</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>use.role.as.xrefstyle</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.role.as.xrefstyle</refname>
<refpurpose>Use <sgmltag class="attribute">role</sgmltag> attribute for
<sgmltag class="attribute">xrefstyle</sgmltag> on <sgmltag>xref</sgmltag>?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the <sgmltag class="attribute">role</sgmltag> attribute on
<sgmltag>xref</sgmltag> will be used to select the cross reference style.
The <ulink url="http://www.oasis-open.org/docbook/">DocBook
Technical Committee</ulink> recently added an
<sgmltag class="attribute">xrefstyle</sgmltag> attribute for this purpose.
If the <sgmltag class="attribute">xrefstyle</sgmltag> attribute
is present, <sgmltag class="attribute">role</sgmltag> will be ignored, regardless
of this setting.</para>

<para>Until an official DocBook release that includes the new
attribute, this flag allows <sgmltag class="attribute">role</sgmltag>
to serve that purpose.</para>

</refsect1><refsect1><title>Example</title>

<para>The following small stylesheet shows how to configure the stylesheets to make
use of the cross reference style:</para>

<programlisting>&lt;?xml version="1.0"?&gt;
&lt;xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0"&gt;

&lt;xsl:import href="../xsl/html/docbook.xsl"/&gt;

&lt;xsl:output method="html"/&gt;

&lt;xsl:param name="local.l10n.xml" select="document('')"/&gt;
&lt;l:i18n xmlns:l="http://docbook.sourceforge.net/xmlns/l10n/1.0"&gt;
  &lt;l:l10n xmlns:l="http://docbook.sourceforge.net/xmlns/l10n/1.0" language="en"&gt;
   &lt;l:context name="xref"&gt;
      &lt;l:template name="chapter" style="title" text="Chapter %n, %t"/&gt;
      &lt;l:template name="chapter" text="Chapter %n"/&gt;
    &lt;/l:context&gt;
  &lt;/l:l10n&gt;
&lt;/l:i18n&gt;

&lt;/xsl:stylesheet&gt;</programlisting>

<para>With this stylesheet, the cross references in the following document:</para>

<programlisting>&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;!DOCTYPE book PUBLIC "-//OASIS//DTD DocBook XML V4.2//EN"
                  "http://www.oasis-open.org/docbook/xml/4.2/docbookx.dtd"&gt;
&lt;book id="book"&gt;&lt;title&gt;Book&lt;/title&gt;

&lt;preface&gt;
&lt;title&gt;Preface&lt;/title&gt;

&lt;para&gt;Normal: &lt;xref linkend="ch1"/&gt;.&lt;/para&gt;
&lt;para&gt;Title: &lt;xref xrefstyle="title" linkend="ch1"/&gt;.&lt;/para&gt;

&lt;/preface&gt;

&lt;chapter id="ch1"&gt;
&lt;title&gt;First Chapter&lt;/title&gt;

&lt;para&gt;Irrelevant.&lt;/para&gt;

&lt;/chapter&gt;
&lt;/book&gt;</programlisting>

<para>will appear as:</para>

<informalexample>
<para>Normal: Chapter 1.</para>
<para>Title: Chapter 1, <emphasis>First Chapter</emphasis>.</para>
</informalexample>
</refsect1>
</doc:refentry>
<xsl:param name="use.role.as.xrefstyle" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>xref.with.number.and.title</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>xref.with.number.and.title</refname>
<refpurpose>Use number and title in cross references</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="xref.with.number.and.title" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>xref.label-page.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>xref.label-page.separator</refname>
<refpurpose>Punctuation or space separating label from page number in xref</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
This parameter allows you to control the punctuation of certain
types of generated cross reference text.
When cross reference text is generated for an 
<sgmltag class="element">xref</sgmltag> or 
<sgmltag class="element">olink</sgmltag> element
using an <sgmltag class="attribute">xrefstyle</sgmltag> attribute
that makes use of the <literal>select:</literal> feature,
and the selected components include both label and page
but no title,
then the value of this parameter is inserted between
label and page number in the output.  
If a title is included, then other separators are used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="xref.label-page.separator"><xsl:text> </xsl:text></xsl:param>

<doc:refentry><refmeta>
<refentrytitle>xref.label-title.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>xref.label-title.separator</refname>
<refpurpose>Punctuation or space separating label from title in xref</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
This parameter allows you to control the punctuation of certain
types of generated cross reference text.
When cross reference text is generated for an 
<sgmltag class="element">xref</sgmltag> or 
<sgmltag class="element">olink</sgmltag> element
using an <sgmltag class="attribute">xrefstyle</sgmltag> attribute
that makes use of the <literal>select:</literal> feature,
and the selected components include both label and title,
then the value of this parameter is inserted between
label and title in the output.  
</para>

</refsect1>
</doc:refentry>
<xsl:param name="xref.label-title.separator">: </xsl:param>

<doc:refentry><refmeta>
<refentrytitle>xref.title-page.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>xref.title-page.separator</refname>
<refpurpose>Punctuation or space separating title from page number in xref</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
This parameter allows you to control the punctuation of certain
types of generated cross reference text.
When cross reference text is generated for an 
<sgmltag class="element">xref</sgmltag> or 
<sgmltag class="element">olink</sgmltag> element
using an <sgmltag class="attribute">xrefstyle</sgmltag> attribute
that makes use of the <literal>select:</literal> feature,
and the selected components include both title and page number,
then the value of this parameter is inserted between
title and page number in the output.  
</para>

</refsect1>
</doc:refentry>
<xsl:param name="xref.title-page.separator"><xsl:text> </xsl:text></xsl:param>

<doc:refentry><refmeta>
<refentrytitle>segmentedlist.as.table</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>segmentedlist.as.table</refname>
<refpurpose>Format segmented lists as tables?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, <sgmltag>segmentedlist</sgmltag>s will be formatted as
tables.</para>

</refsect1>
</doc:refentry>
<xsl:param name="segmentedlist.as.table" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>variablelist.as.table</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>variablelist.as.table</refname>
<refpurpose>Format <sgmltag>variablelist</sgmltag>s as tables?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, <sgmltag>variablelist</sgmltag>s will be formatted as
tables. A processing instruction exists to specify a particualar width for the 
column containing the <sgmltag>term</sgmltag>s:   
<sgmltag class="pi">dbhtml term-width=".25in"</sgmltag></para>

<para>You can override this setting with a processing instruction as the
child of <sgmltag>variablelist</sgmltag>: <sgmltag class="pi">dbhtml
list-presentation="table"</sgmltag> or <sgmltag class="pi">dbhtml
list-presentation="list"</sgmltag>.</para>

<para>This parameter only applys to the HTML transformations. In the
FO case, proper list markup is robust enough to handle the formatting.
But see also <parameter>variablelist.as.blocks</parameter>.</para>

<programlisting>  &lt;variablelist&gt;
        &lt;?dbhtml list-presentation="table"?&gt;
        &lt;?dbhtml term-width="1.5in"?&gt;
        &lt;?dbfo list-presentation="list"?&gt;
        &lt;?dbfo term-width="1in"?&gt;
        &lt;varlistentry&gt;
          &lt;term&gt;list&lt;/term&gt;
          &lt;listitem&gt;
                &lt;para&gt;
                  Formatted as a table even if variablelist.as.table is set to 0.
                &lt;/para&gt;
          &lt;/listitem&gt;
        &lt;/varlistentry&gt;
  &lt;/variablelist&gt;</programlisting>

</refsect1>
</doc:refentry>
<xsl:param name="variablelist.as.table" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>variablelist.term.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>variablelist.term.separator</refname>
<refpurpose>Text to separate <tag>term</tag>s within a multi-term
<tag>varlistentry</tag></refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When a <tag>varlistentry</tag> contains multiple <tag>term</tag>
elements, the string specified in the value of the
<parameter>variablelist.term.separator</parameter> parameter is placed
after each <tag>term</tag> except the last.</para>

<note>
  <para>To generate a line break between multiple <tag>term</tag>s in
  a <tag>varlistentry</tag>, set a non-zero value for the
  <parameter>variablelist.term.break.after</parameter> parameter. If
  you do so, you may also want to set the value of the
  <parameter>variablelist.term.separator</parameter> parameter to an
  empty string (to suppress rendering of the default comma and space
  after each <tag>term</tag>).</para>
</note>

</refsect1>
</doc:refentry>
<xsl:param name="variablelist.term.separator">, </xsl:param>

<doc:refentry><refmeta>
<refentrytitle>variablelist.term.break.after</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>variablelist.term.break.after</refname>
<refpurpose>Generate line break after each <tag>term</tag> within a
multi-term <tag>varlistentry</tag>?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Set a non-zero value for the
<parameter>variablelist.term.break.after</parameter> parameter to
generate a line break between <tag>term</tag>s in a
multi-term <tag>varlistentry</tag>.</para>

<note>
<para>If you set a non-zero value for
<parameter>variablelist.term.break.after</parameter>, you may also
want to set the value of the
<parameter>variablelist.term.separator</parameter> parameter to an
empty string (to suppress rendering of the default comma and space
after each <tag>term</tag>).</para>
</note>

</refsect1>
</doc:refentry>
<xsl:param name="variablelist.term.break.after">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>biblioentry.item.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>biblioentry.item.separator</refname>
<refpurpose>Text to separate bibliography entries</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Text to separate bibliography entries
</para>

</refsect1>
</doc:refentry>
<xsl:param name="biblioentry.item.separator">. </xsl:param>

<doc:refentry><refmeta>
<refentrytitle>bibliography.collection</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>bibliography.collection</refname>
<refpurpose>Name of the bibliography collection file</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Maintaining bibliography entries across a set of documents is tedious, time
consuming, and error prone. It makes much more sense, usually, to store all of
the bibliography entries in a single place and simply <quote>extract</quote>
the ones you need in each document.</para>

<para>That's the purpose of the
<parameter>bibliography.collection</parameter> parameter. To setup a global
bibliography <quote>database</quote>, follow these steps:</para>

<para>First, create a stand-alone bibliography document that contains all of
the documents that you wish to reference. Make sure that each bibliography
entry (whether you use <sgmltag>biblioentry</sgmltag> or <sgmltag>bibliomixed</sgmltag>)
has an ID.</para>

<para>My global bibliography, <filename>~/bibliography.xml</filename> begins
like this:</para>

<informalexample>
<programlisting>&lt;!DOCTYPE bibliography
  PUBLIC "-//OASIS//DTD DocBook XML V4.1.2//EN"
  "http://www.oasis-open.org/docbook/xml/4.1.2/docbookx.dtd"&gt;
&lt;bibliography&gt;&lt;title&gt;References&lt;/title&gt;

&lt;bibliomixed id="xml-rec"&gt;&lt;abbrev&gt;XML 1.0&lt;/abbrev&gt;Tim Bray,
Jean Paoli, C. M. Sperberg-McQueen, and Eve Maler, editors.
&lt;citetitle&gt;&lt;ulink url="http://www.w3.org/TR/REC-xml"&gt;Extensible Markup
Language (XML) 1.0 Second Edition&lt;/ulink&gt;&lt;/citetitle&gt;.
World Wide Web Consortium, 2000.
&lt;/bibliomixed&gt;

&lt;bibliomixed id="xml-names"&gt;&lt;abbrev&gt;Namespaces&lt;/abbrev&gt;Tim Bray,
Dave Hollander,
and Andrew Layman, editors.
&lt;citetitle&gt;&lt;ulink url="http://www.w3.org/TR/REC-xml-names/"&gt;Namespaces in
XML&lt;/ulink&gt;&lt;/citetitle&gt;.
World Wide Web Consortium, 1999.
&lt;/bibliomixed&gt;

&lt;!-- ... --&gt;
&lt;/bibliography&gt;
</programlisting>
</informalexample>

<para>When you create a bibliography in your document, simply
provide <emphasis>empty</emphasis> <sgmltag>bibliomixed</sgmltag>
entries for each document that you wish to cite. Make sure that these
elements have the same ID as the corresponding <quote>real</quote>
entry in your global bibliography.</para>

<para>For example:</para>

<informalexample>
<programlisting>&lt;bibliography&gt;&lt;title&gt;Bibliography&lt;/title&gt;

&lt;bibliomixed id="xml-rec"/&gt;
&lt;bibliomixed id="xml-names"/&gt;
&lt;bibliomixed id="DKnuth86"&gt;Donald E. Knuth. &lt;citetitle&gt;Computers and
Typesetting: Volume B, TeX: The Program&lt;/citetitle&gt;. Addison-Wesley,
1986.  ISBN 0-201-13437-3.
&lt;/bibliomixed&gt;
&lt;bibliomixed id="relaxng"/&gt;

&lt;/bibliography&gt;</programlisting>
</informalexample>

<para>Note that it's perfectly acceptable to mix entries from your
global bibliography with <quote>normal</quote> entries. You can use
<sgmltag>xref</sgmltag> or other elements to cross-reference your
bibliography entries in exactly the same way you do now.</para>

<para>Finally, when you are ready to format your document, simply set the
<parameter>bibliography.collection</parameter> parameter (in either a
customization layer or directly through your processor's interface) to
point to your global bibliography.</para>

<para>The stylesheets will format the bibliography in your document as if
all of the entries referenced appeared there literally.</para>

</refsect1>
</doc:refentry>
<xsl:param name="bibliography.collection" select="'http://docbook.sourceforge.net/release/bibliography/bibliography.xml'"/>

<doc:refentry><refmeta>
<refentrytitle>bibliography.numbered</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>bibliography.numbered</refname>
<refpurpose>Should bibliography entries be numbered?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero bibliography entries will be numbered</para>

</refsect1>
</doc:refentry>
<xsl:param name="bibliography.numbered" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>glossterm.auto.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>glossterm.auto.link</refname>
<refpurpose>Generate links from glossterm to glossentry automaticaly?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, a link will be automatically created from glossterm 
to glossentry for that glossary term. This is usefull when your
glossterm names are consistent and you don't want to add links
manually.</para>
<para>If there is <sgmltag class="attribute">linkend</sgmltag> on
<sgmltag>glossterm</sgmltag> then is used instead of autogeneration of
link.</para>

</refsect1>
</doc:refentry>
<xsl:param name="glossterm.auto.link" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>firstterm.only.link</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>firstterm.only.link</refname>
<refpurpose>Does automatic glossterm linking only apply to firstterms?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true, only <sgmltag>firstterm</sgmltag>s will be automatically linked
to the glossary. If glossary linking is not enabled, this parameter
has no effect.</para>

</refsect1>
</doc:refentry>
<xsl:param name="firstterm.only.link" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>glossary.collection</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>glossary.collection</refname>
<refpurpose>Name of the glossary collection file</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Glossaries maintained independently across a set of documents
are likely to become inconsistent unless considerable effort is
expended to keep them in sync. It makes much more sense, usually, to
store all of the glossary entries in a single place and simply
<quote>extract</quote> the ones you need in each document.</para>

<para>That's the purpose of the
<parameter>glossary.collection</parameter> parameter. To setup a global
glossary <quote>database</quote>, follow these steps:</para>

<refsect2><title>Setting Up the Glossary Database</title>

<para>First, create a stand-alone glossary document that contains all of
the entries that you wish to reference. Make sure that each glossary
entry has an ID.</para>

<para>Here's an example glossary:</para>

<informalexample>
<programlisting>
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;!DOCTYPE glossary
  PUBLIC "-//OASIS//DTD DocBook XML V4.1.2//EN"
  "http://www.oasis-open.org/docbook/xml/4.1.2/docbookx.dtd"&gt;
&lt;glossary&gt;
&lt;glossaryinfo&gt;
&lt;editor&gt;&lt;firstname&gt;Eric&lt;/firstname&gt;&lt;surname&gt;Raymond&lt;/surname&gt;&lt;/editor&gt;
&lt;title&gt;Jargon File 4.2.3 (abridged)&lt;/title&gt;
&lt;releaseinfo&gt;Just some test data&lt;/releaseinfo&gt;
&lt;/glossaryinfo&gt;

&lt;glossdiv&gt;&lt;title&gt;0&lt;/title&gt;

&lt;glossentry&gt;
&lt;glossterm&gt;0&lt;/glossterm&gt;
&lt;glossdef&gt;
&lt;para&gt;Numeric zero, as opposed to the letter `O' (the 15th letter of
the English alphabet). In their unmodified forms they look a lot
alike, and various kluges invented to make them visually distinct have
compounded the confusion. If your zero is center-dotted and letter-O
is not, or if letter-O looks almost rectangular but zero looks more
like an American football stood on end (or the reverse), you're
probably looking at a modern character display (though the dotted zero
seems to have originated as an option on IBM 3270 controllers). If
your zero is slashed but letter-O is not, you're probably looking at
an old-style ASCII graphic set descended from the default typewheel on
the venerable ASR-33 Teletype (Scandinavians, for whom /O is a letter,
curse this arrangement). (Interestingly, the slashed zero long
predates computers; Florian Cajori's monumental "A History of
Mathematical Notations" notes that it was used in the twelfth and
thirteenth centuries.) If letter-O has a slash across it and the zero
does not, your display is tuned for a very old convention used at IBM
and a few other early mainframe makers (Scandinavians curse &lt;emphasis&gt;this&lt;/emphasis&gt;
arrangement even more, because it means two of their letters collide).
Some Burroughs/Unisys equipment displays a zero with a &lt;emphasis&gt;reversed&lt;/emphasis&gt;
slash. Old CDC computers rendered letter O as an unbroken oval and 0
as an oval broken at upper right and lower left. And yet another
convention common on early line printers left zero unornamented but
added a tail or hook to the letter-O so that it resembled an inverted
Q or cursive capital letter-O (this was endorsed by a draft ANSI
standard for how to draw ASCII characters, but the final standard
changed the distinguisher to a tick-mark in the upper-left corner).
Are we sufficiently confused yet?&lt;/para&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;

&lt;glossentry&gt;
&lt;glossterm&gt;1TBS&lt;/glossterm&gt;
&lt;glossdef&gt;
&lt;para role="accidence"&gt;
&lt;phrase role="pronounce"&gt;&lt;/phrase&gt;
&lt;phrase role="partsofspeach"&gt;n&lt;/phrase&gt;
&lt;/para&gt;
&lt;para&gt;The "One True Brace Style"&lt;/para&gt;
&lt;glossseealso&gt;indent style&lt;/glossseealso&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;

&lt;!-- ... --&gt;

&lt;/glossdiv&gt;

&lt;!-- ... --&gt;

&lt;/glossary&gt;</programlisting>
</informalexample>

</refsect2>

<refsect2><title>Marking Up Glossary Terms</title>

<para>That takes care of the glossary database, now you have to get the entries
into your document. Unlike bibliography entries, which can be empty, creating
<quote>placeholder</quote> glossary entries would be very tedious. So instead,
support for <parameter>glossary.collection</parameter> relies on implicit linking.</para>

<para>In your source document, simply use <sgmltag>firstterm</sgmltag> and
<sgmltag>glossterm</sgmltag> to identify the terms you wish to have included
in the glossary. The stylesheets assume that you will either set the
<sgmltag class="attribute">baseform</sgmltag> attribute correctly, or that the
content of the element exactly matches a term in your glossary.</para>

<para>If you're using a <parameter>glossary.collection</parameter>, don't
make explicit links on the terms in your document.</para>

<para>So, in your document, you might write things like this:</para>

<informalexample>
<programlisting>&lt;para&gt;This is dummy text, without any real meaning.
The point is simply to reference glossary terms like &lt;glossterm&gt;0&lt;/glossterm&gt;
and the &lt;firstterm baseform="1TBS"&gt;One True Brace Style (1TBS)&lt;/firstterm&gt;.
The &lt;glossterm&gt;1TBS&lt;/glossterm&gt;, as you can probably imagine, is a nearly
religious issue.&lt;/para&gt;</programlisting>
</informalexample>

<para>If you set the <parameter>firstterm.only.link</parameter> parameter,
only the terms marked with <sgmltag>firstterm</sgmltag> will be links.
Otherwise, all the terms will be linked.</para>

</refsect2>

<refsect2><title>Marking Up the Glossary</title>

<para>The glossary itself has to be identified for the stylesheets. For lack
of a better choice, the <sgmltag class="attribute">role</sgmltag> is used.
To identify the glossary as the target for automatic processing, set
the role to <quote><literal>auto</literal></quote>. The title of this
glossary (and any other information from the <sgmltag>glossaryinfo</sgmltag>
that's rendered by your stylesheet) will be displayed, but the entries will
come from the database.
</para>

<para>Unfortunately, the glossary can't be empty, so you must put in
at least one <sgmltag>glossentry</sgmltag>. The content of this entry
is irrelevant, it will not be rendered:</para>

<informalexample>
<programlisting>&lt;glossary role="auto"&gt;
&lt;glossentry&gt;
&lt;glossterm&gt;Irrelevant&lt;/glossterm&gt;
&lt;glossdef&gt;
&lt;para&gt;If you can see this, the document was processed incorrectly. Use
the &lt;parameter&gt;glossary.collection&lt;/parameter&gt; parameter.&lt;/para&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;
&lt;/glossary&gt;</programlisting>
</informalexample>

<para>What about glossary divisions? If your glossary database has glossary
divisions <emphasis>and</emphasis> your automatic glossary contains at least
one <sgmltag>glossdiv</sgmltag>, the automic glossary will have divisions.
If the <sgmltag>glossdiv</sgmltag> is missing from either location, no divisions
will be rendered.</para>

<para>Glossary entries (and divisions, if appropriate) in the glossary will
occur in precisely the order they occur in your database.</para>

</refsect2>

<refsect2><title>Formatting the Document</title>

<para>Finally, when you are ready to format your document, simply set the
<parameter>glossary.collection</parameter> parameter (in either a
customization layer or directly through your processor's interface) to
point to your global glossary.</para>

<para>The stylesheets will format the glossary in your document as if
all of the entries implicilty referenced appeared there literally.</para>
</refsect2>

<refsect2><title>Limitations</title>

<para>Glossary cross-references <emphasis>within the glossary</emphasis> are
not supported. For example, this <emphasis>will not</emphasis> work:</para>

<informalexample>
<programlisting>&lt;glossentry&gt;
&lt;glossterm&gt;gloss-1&lt;/glossterm&gt;
&lt;glossdef&gt;&lt;para&gt;A description that references &lt;glossterm&gt;gloss-2&lt;/glossterm&gt;.&lt;/para&gt;
&lt;glossseealso&gt;gloss-2&lt;/glossseealso&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;</programlisting>
</informalexample>

<para>If you put glossary cross-references in your glossary that way,
you'll get the cryptic error: <computeroutput>Warning:
glossary.collection specified, but there are 0 automatic
glossaries</computeroutput>.</para>

<para>Instead, you must do two things:</para>

<orderedlist>
<listitem>
<para>Markup your glossary using <sgmltag>glossseealso</sgmltag>:</para>

<informalexample>
<programlisting>&lt;glossentry&gt;
&lt;glossterm&gt;gloss-1&lt;/glossterm&gt;
&lt;glossdef&gt;&lt;para&gt;A description that references &lt;glossterm&gt;gloss-2&lt;/glossterm&gt;.&lt;/para&gt;
&lt;glossseealso&gt;gloss-2&lt;/glossseealso&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;</programlisting>
</informalexample>
</listitem>

<listitem>
<para>Make sure there is at least one <sgmltag>glossterm</sgmltag> reference to
<glossterm>gloss-2</glossterm> <emphasis>in your document</emphasis>. The
easiest way to do that is probably within a <sgmltag>remark</sgmltag> in your
automatic glossary:</para>

<informalexample>
<programlisting>&lt;glossary role="auto"&gt;
&lt;remark&gt;Make sure there's a reference to &lt;glossterm&gt;gloss-2&lt;/glossterm&gt;.&lt;/remark&gt;
&lt;glossentry&gt;
&lt;glossterm&gt;Irrelevant&lt;/glossterm&gt;
&lt;glossdef&gt;
&lt;para&gt;If you can see this, the document was processed incorrectly. Use
the &lt;parameter&gt;glossary.collection&lt;/parameter&gt; parameter.&lt;/para&gt;
&lt;/glossdef&gt;
&lt;/glossentry&gt;
&lt;/glossary&gt;</programlisting>
</informalexample>
</listitem>
</orderedlist>
</refsect2>

</refsect1>
</doc:refentry>
<xsl:param name="glossary.collection" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>glossentry.show.acronym</refentrytitle>
<refmiscinfo role="type">list</refmiscinfo>
</refmeta><refnamediv>
<refname>glossentry.show.acronym</refname>
<refpurpose>Display <sgmltag>glossentry</sgmltag> acronyms?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>A setting of <quote>yes</quote> means they should be displayed;
<quote>no</quote> means they shouldn't. If <quote>primary</quote> is used,
then they are shown as the primary text for the entry.</para>

<note>
<para>This setting controls both <sgmltag>acronym</sgmltag> and
<sgmltag>abbrev</sgmltag> elements in the <sgmltag>glossentry</sgmltag>.</para>
</note>

</refsect1>
</doc:refentry>
<xsl:param name="glossentry.show.acronym" select="'no'"/>

<doc:refentry><refmeta>
<refentrytitle>formal.procedures</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>formal.procedures</refname>
<refpurpose>Selects formal or informal procedures</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Formal procedures are numbered and always have a title.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="formal.procedures" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>formal.title.placement</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>formal.title.placement</refname>
<refpurpose>Specifies where formal object titles should occur</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Specifies where formal object titles should occur. For each formal object
type (<sgmltag>figure</sgmltag>,
<sgmltag>example</sgmltag>,
<sgmltag>equation</sgmltag>,
<sgmltag>table</sgmltag>, and <sgmltag>procedure</sgmltag>)
you can specify either the keyword
<quote><literal>before</literal></quote> or
<quote><literal>after</literal></quote>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="formal.title.placement">
figure before
example before
equation before
table before
procedure before
task before
</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>runinhead.default.title.end.punct</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>runinhead.default.title.end.punct</refname>
<refpurpose>Default punctuation character on a run-in-head</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:
</para>

</refsect1>
</doc:refentry>
<xsl:param name="runinhead.default.title.end.punct" select="'.'"/>

<doc:refentry><refmeta>
<refentrytitle>runinhead.title.end.punct</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>runinhead.title.end.punct</refname>
<refpurpose>Characters that count as punctuation on a run-in-head</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:
</para>

</refsect1>
</doc:refentry>
<xsl:param name="runinhead.title.end.punct" select="'.!?:'"/>

<doc:refentry><refmeta>
<refentrytitle>show.comments</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>show.comments</refname>
<refpurpose>Display <sgmltag>comment</sgmltag> elements?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), comments will be displayed, otherwise they are suppressed.
Comments here refers to the <sgmltag>comment</sgmltag> element,
which will be renamed <sgmltag>remark</sgmltag> in DocBook V4.0,
not XML comments (&lt;-- like this --&gt;) which are unavailable.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="show.comments">1</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>show.revisionflag</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>show.revisionflag</refname>
<refpurpose>Enable decoration of elements that have a revisionflag</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>
If <literal>show.revisionflag</literal> is turned on, then the stylesheets
may produce additional markup designed to allow a CSS stylesheet to
highlight elements that have specific revisionflag settings.</para>

<para>The markup inserted will be usually be either a &lt;span&gt; or &lt;div&gt;
with an appropriate <literal>class</literal> attribute. (The value of
the class attribute will be the same as the value of the revisionflag
attribute). In some contexts, for example tables, where extra markup
would be structurally illegal, the class attribute will be added to the
appropriate container element.</para>

<para>In general, the stylesheets only test for revisionflag in contexts
where an importing stylesheet would have to redefine whole templates.
Most of the revisionflag processing is expected to be done by another
stylesheet, for example <filename>changebars.xsl</filename>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="show.revisionflag">0</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>shade.verbatim</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>shade.verbatim</refname>
<refpurpose>Should verbatim environments be shaded?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>In the FO stylesheet, if this parameter is non-zero then the
<property>shade.verbatim.style</property> properties will be applied
to verbatim environments.</para>

<para>In the HTML stylesheet, this parameter is now deprecated. Use
CSS instead.</para>

</refsect1>
</doc:refentry>
<xsl:param name="shade.verbatim" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>shade.verbatim.style</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>shade.verbatim.style</refname>
<refpurpose>Properties that specify the style of shaded verbatim listings</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:attribute-set name="shade.verbatim.style">
  <xsl:attribute name="border">0</xsl:attribute>
  <xsl:attribute name="bgcolor">#E0E0E0</xsl:attribute>
</xsl:attribute-set>


<doc:refentry><refmeta>
<refentrytitle>punct.honorific</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>punct.honorific</refname>
<refpurpose>Punctuation after an honorific in a personal name.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the punctuation that should be added after an
honorific in a personal name.</para>

</refsect1>
</doc:refentry>
<xsl:param name="punct.honorific" select="'.'"/>

<doc:refentry><refmeta>
<refentrytitle>tex.math.in.alt</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>tex.math.in.alt</refname>
<refpurpose>TeX notation used for equations</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want type math directly in TeX notation in equations,
this parameter specifies notation used. Currently are supported two
values -- <literal>plain</literal> and <literal>latex</literal>. Empty
value means that you are not using TeX math at all.</para>

<para>Preferred way for including TeX alternative of math is inside of
<sgmltag>textobject</sgmltag> element. Eg.:</para>

<programlisting>&lt;inlineequation&gt;
&lt;inlinemediaobject&gt;
&lt;imageobject&gt;
&lt;imagedata fileref="eq1.gif"/&gt;
&lt;/imageobject&gt;
&lt;textobject&gt;&lt;phrase&gt;E=mc squared&lt;/phrase&gt;&lt;/textobject&gt;
&lt;textobject role="tex"&gt;&lt;phrase&gt;E=mc^2&lt;/phrase&gt;&lt;/textobject&gt;
&lt;/inlinemediaobject&gt;
&lt;/inlineequation&gt;</programlisting>

<para>If you are using <sgmltag>graphic</sgmltag> element, you can
store TeX inside <sgmltag>alt</sgmltag> element:</para>

<programlisting>&lt;inlineequation&gt;
&lt;alt role="tex"&gt;a^2+b^2=c^2&lt;/alt&gt;
&lt;graphic fileref="a2b2c2.gif"/&gt;  
&lt;/inlineequation&gt;</programlisting>

<para>If you want use this feature, you should process your FO with
PassiveTeX, which only supports TeX math notation. When calling
stylsheet, don't forget to specify also
passivetex.extensions=1.</para>

<para>If you want equations in HTML, just process generated file
<filename>tex-math-equations.tex</filename> by TeX or LaTeX. Then run
dvi2bitmap program on result DVI file. You will get images for
equations in your document.</para>

</refsect1>
</doc:refentry>
<xsl:param name="tex.math.in.alt" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>tex.math.file</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>tex.math.file</refname>
<refpurpose>Name of temporary file for generating images from equations</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Name of auxiliary file for TeX equations. This file can be
processed by dvi2bitmap to get bitmap versions of equations for HTML
output.</para>

</refsect1>
</doc:refentry>
<xsl:param name="tex.math.file" select="'tex-math-equations.tex'"/>

<doc:refentry><refmeta>
<refentrytitle>tex.math.delims</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>tex.math.delims</refname>
<refpurpose>Should be equations outputed for processing by TeX
automatically surrounded by math mode delimiters</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>For compatibility with DSSSL based DBTeXMath from Allin Cottrell
you should set this parameter to 0.</para>

</refsect1>
</doc:refentry>
<xsl:param name="tex.math.delims" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>pixels.per.inch</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>pixels.per.inch</refname>
<refpurpose>How many pixels are there per inch?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When lengths are converted to pixels, this value is used to
determine the size of a pixel. The default value is taken from the
<ulink url="http://www.w3.org/TR/xsl/slice5.html#pixels">XSL
Recommendation</ulink>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="pixels.per.inch" select="90"/>

<doc:refentry><refmeta>
<refentrytitle>points.per.em</refentrytitle>
<refmiscinfo role="type">number</refmiscinfo>
</refmeta><refnamediv>
<refname>points.per.em</refname>
<refpurpose>Specify the nominal size of an em-space in points</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="points.per.em" select="10"/>

<doc:refentry><refmeta>
<refentrytitle>use.svg</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.svg</refname>
<refpurpose>Allow SVG in the result tree?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, SVG will be considered an acceptable image format. SVG
is passed through to the result tree, so correct rendering of the resulting
diagram depends on the formatter (FO processor or web browser) that is used
to process the output from the stylesheet.</para>

</refsect1>
</doc:refentry>
<xsl:param name="use.svg" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>menuchoice.separator</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>menuchoice.separator</refname>
<refpurpose>Separator between items of a <sgmltag>menuchoice</sgmltag>
other than <sgmltag>guimenuitem</sgmltag> and
<sgmltag>guisubmenu</sgmltag></refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Separator used to connect items of a <sgmltag>menuchoice</sgmltag> other
than <sgmltag>guimenuitem</sgmltag> and <sgmltag>guisubmenu</sgmltag>. The latter
elements are linked with <parameter>menuchoice.menu.separator</parameter>.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="menuchoice.separator" select="'+'"/>

<doc:refentry><refmeta>
<refentrytitle>menuchoice.menu.separator</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>menuchoice.menu.separator</refname>
<refpurpose>Separator between items of a <sgmltag>menuchoice</sgmltag>
with <sgmltag>guimenuitem</sgmltag> or
<sgmltag>guisubmenu</sgmltag></refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Separator used to connect items of a <sgmltag>menuchoice</sgmltag> with
<sgmltag>guimenuitem</sgmltag> or <sgmltag>guisubmenu</sgmltag>. Other elements
are linked with <parameter>menuchoice.separator</parameter>.
</para>
<para>The default value is &amp;#x2192;, which is the
&amp;rarr; (right arrow) character entity.  
The current FOP (0.20.5) requires setting the font-family
explicitly.
</para>
<para>The default value also includes spaces around the arrow,
which will allow a line to break.  Replace the spaces with
&amp;#xA0; (nonbreaking space) if you don't want those
spaces to break.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="menuchoice.menu.separator"> → </xsl:param>

<doc:refentry><refmeta>
<refentrytitle>default.float.class</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>default.float.class</refname>
<refpurpose>Specifies the default float class</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>FIXME:</para>

</refsect1>
</doc:refentry>
<xsl:param name="default.float.class">
  <xsl:choose>
    <xsl:when test="contains($stylesheet.result.type,'html')">left</xsl:when>
    <xsl:otherwise>before</xsl:otherwise>
  </xsl:choose>
</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>footnote.number.format</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>footnote.number.format</refname>
<refpurpose>Identifies the format used for footnote numbers</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>footnote.number.format</parameter> specifies the format
to use for footnote numeration (1, i, I, a, or A).</para>

</refsect1>
</doc:refentry>
<xsl:param name="footnote.number.format" select="'1'"/>

<doc:refentry><refmeta>
<refentrytitle>table.footnote.number.format</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>table.footnote.number.format</refname>
<refpurpose>Identifies the format used for footnote numbers in tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>table.footnote.number.format</parameter> specifies the format
to use for footnote numeration (1, i, I, a, or A) in tables.</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.footnote.number.format" select="'a'"/>

<doc:refentry><refmeta>
<refentrytitle>footnote.number.symbols</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>footnote.number.symbols</refname>
<refpurpose>Special characters to use as footnote markers</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>footnote.number.symbols</parameter> is not the empty string,
footnotes will use the characters it contains as footnote symbols. For example,
<quote>*&amp;#x2020;&amp;#x2021;&amp;#x25CA;&amp;#x2720;</quote> will identify
footnotes with <quote>*</quote>, <quote>†</quote>, <quote>‡</quote>,
<quote>◊</quote>, and <quote>✠</quote>. If there are more footnotes
than symbols, the stylesheets will fall back to numbered footnotes using
<parameter>footnote.number.format</parameter>.</para>

<para>The use of symbols for footnotes depends on the ability of your
processor (or browser) to render the symbols you select. Not all systems are
capable of displaying the full range of Unicode characters. If the quoted characters
in the preceding paragraph are not displayed properly, that's a good indicator
that you may have trouble using those symbols for footnotes.</para>

</refsect1>
</doc:refentry>
<xsl:param name="footnote.number.symbols" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>table.footnote.number.symbols</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>table.footnote.number.symbols</refname>
<refpurpose>Special characters to use a footnote markers in tables</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>table.footnote.number.symbols</parameter> is not the empty string,
table footnotes will use the characters it contains as footnote symbols. For example,
<quote>*&amp;#x2020;&amp;#x2021;&amp;#x25CA;&amp;#x2720;</quote> will identify
footnotes with <quote>*</quote>, <quote>†</quote>, <quote>‡</quote>,
<quote>◊</quote>, and <quote>✠</quote>. If there are more footnotes
than symbols, the stylesheets will fall back to numbered footnotes using
<parameter>table.footnote.number.format</parameter>.</para>

<para>The use of symbols for footnotes depends on the ability of your
processor (or browser) to render the symbols you select. Not all systems are
capable of displaying the full range of Unicode characters. If the quoted characters
in the preceding paragraph are not displayed properly, that's a good indicator
that you may have trouble using those symbols for footnotes.</para>

</refsect1>
</doc:refentry>
<xsl:param name="table.footnote.number.symbols" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>annotation.support</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotation.support</refname>
<refpurpose>Enable annotations?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the stylesheets will attempt to support annotation
elements in HTML by including some JavaScript (see
<parameter>annotation.js</parameter>).</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotation.support" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>annotation.js</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotation.js</refname>
<refpurpose>Enable annotations?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <property>annotation.support</property> is enabled and the
document contains <sgmltag>annotation</sgmltag>s, then the URIs listed
in this parameter will be included. These JavaScript files are required
for popup annotation support.</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotation.js" select="'http://docbook.sourceforge.net/release/script/AnchorPosition.js             http://docbook.sourceforge.net/release/script/PopupWindow.js'"/>

<doc:refentry><refmeta>
<refentrytitle>annotation.css</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotation.css</refname>
<refpurpose>Enable annotations?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <property>annotation.support</property> is enabled and the
document contains <sgmltag>annotation</sgmltag>s, then the CSS in this
parameter will be included in the document.</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotation.css">
/* ======================================================================
   Annotations
*/

div.annotation-list  { visibility: hidden;
                     }

div.annotation-nocss { position: absolute;
                       visibility: hidden;
                     }

div.annotation-popup { position: absolute;
                       z-index: 4;
                       visibility: hidden;
                       padding: 0px;
                       margin: 2px;
                       border-style: solid;
                       border-width: 1px;
                       width: 200px;
		       background-color: white;
                     }

div.annotation-title { padding: 1px;
                       font-weight: bold;
                       border-bottom-style: solid;
                       border-bottom-width: 1px;
		       color: white;
		       background-color: black;
                     }

div.annotation-body  { padding: 2px;
                     }

div.annotation-body p { margin-top: 0px;
                        padding-top: 0px;
                      }

div.annotation-close { position: absolute;
                       top: 2px;
                       right: 2px;
                     }
</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>annotation.graphic.open</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotation.graphic.open</refname>
<refpurpose>Enable annotations?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This image is used inline to identify the location of
annotations.</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotation.graphic.open" select="'http://docbook.sourceforge.net/release/images/annot-open.png'"/>

<doc:refentry><refmeta>
<refentrytitle>annotation.graphic.close</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>annotation.graphic.close</refname>
<refpurpose>Enable annotations?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This image is used on popup annotations as the “x” that the
user can click to dismiss the popup.</para>

</refsect1>
</doc:refentry>
<xsl:param name="annotation.graphic.close" select="'http://docbook.sourceforge.net/release/images/annot-close.png'"/>

<doc:refentry><refmeta>
<refentrytitle>img.src.path</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>img.src.path</refname>
<refpurpose>Path to HTML image files</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Add a path prefix to each HTML
<sgmltag class="element">img</sgmltag> or FO 
<sgmltag class="element">fo:external-graphics</sgmltag> element's
<sgmltag class="attribute">src</sgmltag> attribute.
This path could relative to the directory where the HTML/FO
files are created, or it could be an absolute URI.
The default value is empty.
Be sure to include a trailing slash if needed.
</para>
<para>This prefix is not applied to any filerefs that start
with "/" or contain "//:".
</para>

</refsect1>
</doc:refentry>
<xsl:param name="img.src.path"/>

<doc:refentry><refmeta>
<refentrytitle>keep.relative.image.uris</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>keep.relative.image.uris</refname>
<refpurpose>Should image URIs be resolved against xml:base?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zeor, relative URIs (in, for example fileref attributes) will
be used in the generated output. Otherwise, the URIs will be made absolute
with respect to the base URI.</para>

<para>Note that the stylesheets calculate (and use) the absolute form
for some purposes, this only applies to the resulting output.</para>

</refsect1>
</doc:refentry>
<xsl:param name="keep.relative.image.uris" select="1"/>


<doc:refentry><refmeta>
<refentrytitle>graphic.default.extension</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>graphic.default.extension</refname>
<refpurpose>Default extension for graphic filenames</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If a <sgmltag>graphic</sgmltag> or <sgmltag>mediaobject</sgmltag>
includes a reference to a filename that does not include an extension,
and the <sgmltag class="attribute">format</sgmltag> attribute is
<emphasis>unspecified</emphasis>, the default extension will be used.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="graphic.default.extension"/>

<doc:refentry><refmeta>
<refentrytitle>default.image.width</refentrytitle>
<refmiscinfo role="type">length</refmiscinfo>
</refmeta><refnamediv>
<refname>default.image.width</refname>
<refpurpose>The default width of images</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If specified, this value will be used for the
<sgmltag class="attribute">width</sgmltag> attribute on
images that do not specify any
<ulink url="http://docbook.org/tdg/en/html/imagedata.html#viewport.area">viewport
dimensions</ulink>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="default.image.width" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>nominal.image.width</refentrytitle>
<refmiscinfo role="type">length</refmiscinfo>
</refmeta><refnamediv>
<refname>nominal.image.width</refname>
<refpurpose>The nominal image width</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Graphic widths expressed as a percentage are problematic. In the
following discussion, we speak of width and contentwidth, but
the same issues apply to depth and contentdepth.</para>

<para>A width of 50% means "half of the available space for the image."
That's fine. But note that in HTML, this is a dynamic property and
the image size will vary if the browser window is resized.</para>

<para>A contentwidth of 50% means "half of the actual image width".
But what does that mean if the stylesheets cannot assess the image's
actual size? Treating this as a width of 50% is one possibility, but
it produces behavior (dynamic scaling) that seems entirely out of
character with the meaning.</para>

<para>Instead, the stylesheets define a
<parameter>nominal.image.width</parameter> and convert percentages to
actual values based on that nominal size.</para>

</refsect1>
</doc:refentry>
<xsl:param name="nominal.image.width" select="6 * $pixels.per.inch"/>

<doc:refentry><refmeta>
<refentrytitle>nominal.image.depth</refentrytitle>
<refmiscinfo role="type">length</refmiscinfo>
</refmeta><refnamediv>
<refname>nominal.image.depth</refname>
<refpurpose>Nominal image depth</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>See <parameter>nominal.image.width</parameter>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="nominal.image.depth" select="4 * $pixels.per.inch"/>

<doc:refentry><refmeta>
<refentrytitle>use.embed.for.svg</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.embed.for.svg</refname>
<refpurpose>Use HTML <sgmltag>embed</sgmltag> for SVG?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, an <sgmltag>embed</sgmltag> element will be created for
SVG figures. An <sgmltag>object</sgmltag> is <emphasis>always</emphasis> created,
this parameter merely controls whether or not an additional <sgmltag>embed</sgmltag>
is generated inside the <sgmltag>object</sgmltag>.</para>

<para>On the plus side, this may be more portable among browsers and plug-ins.
On the minus side, it isn't valid HTML.</para>

</refsect1>
</doc:refentry>
<xsl:param name="use.embed.for.svg" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>make.graphic.viewport</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>make.graphic.viewport</refname>
<refpurpose>Use tables in HTML to make viewports for graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The HTML <sgmltag>img</sgmltag> element only supports the notion
of content-area scaling; it doesn't support the distinction between a
content-area and a viewport-area, so we have to make some compromises.</para>

<para>If <parameter>make.graphic.viewport</parameter> is non-zero, a table
will be used to frame the image. This creates an effective viewport-area.
</para>

<para>Tables and alignment don't work together, so this parameter is ignored
if alignment is specified on an image.</para>
</refsect1>
</doc:refentry>
<xsl:param name="make.graphic.viewport" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>preferred.mediaobject.role</refentrytitle>
</refmeta><refnamediv>
<refname>preferred.mediaobject.role</refname>
<refpurpose>Select which mediaobject to use based on
this value of an object's <sgmltag class="attribute">role</sgmltag> attribute.
</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>A mediaobject may contain several objects such as imageobjects.
If the parameter <parameter>use.role.for.mediaobject</parameter>
is non-zero, then the <sgmltag class="attribute">role</sgmltag> attribute on
<sgmltag>imageobject</sgmltag>s and other objects within a <sgmltag>mediaobject</sgmltag> container will be used to select which object will be
used.  If one of the objects has a role value that matches the
preferred.mediaobject.role parameter, then it has first
priority for selection.  If more than one has such a
role value, the first one is used.
</para>
<para>
See the <parameter>use.role.for.mediaobject</parameter> parameter
for the sequence of selection.</para>
</refsect1>
</doc:refentry>
<xsl:param name="preferred.mediaobject.role"/>

<doc:refentry><refmeta>
<refentrytitle>use.role.for.mediaobject</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.role.for.mediaobject</refname>
<refpurpose>Use <sgmltag class="attribute">role</sgmltag> attribute 
value for selecting which of several objects within a mediaobject to use.
</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the <sgmltag class="attribute">role</sgmltag> attribute on
<sgmltag>imageobject</sgmltag>s or other objects within a <sgmltag>mediaobject</sgmltag> container will be used to select which object will be
used.
</para>
<para>
The order of selection when then parameter is non-zero is:
</para>
<orderedlist>
<listitem>
    <para>If the stylesheet parameter <parameter>preferred.mediaobject.role</parameter> has a value, then the object whose role equals that value is selected.</para>
</listitem>
<listitem>
<para>Else if an object's role attribute has a value of
<literal>html</literal> for HTML processing or
<literal>fo</literal> for FO output, then the first
of such objects is selected.
</para>
</listitem>
<listitem>
<para>Else the first suitable object is selected.</para>
</listitem>
</orderedlist>
<para>
If the value of 
<parameter>use.role.for.mediaobject</parameter>
is zero, then role attributes are not considered
and the first suitable object
with or without a role value is used.
</para>
</refsect1>
</doc:refentry>
<xsl:param name="use.role.for.mediaobject" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>ignore.image.scaling</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>ignore.image.scaling</refname>
<refpurpose>Tell the stylesheets to ignore the author's image scaling attributes</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the scaling attributes on graphics and media objects are
ignored.</para>

</refsect1>
</doc:refentry>
<xsl:param name="ignore.image.scaling" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>chunker.output.cdata-section-elements</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.cdata-section-elements</refname>
<refpurpose>List of elements to escape with CDATA sections</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.cdata-section-elements" select="''"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the list of elements that should be escaped
as CDATA sections by the chunking stylesheet.  Not all processors support
specification of this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.doctype-public</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.doctype-public</refname>
<refpurpose>Public identifer to use in the document type of generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.doctype-public" select="''"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the public identifier that should be used by
the chunking stylesheet in the document type declaration of chunked pages.
Not all processors support specification of
this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.doctype-system</refentrytitle>
<refmiscinfo role="type">uri</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.doctype-system</refname>
<refpurpose>System identifier to use for the document type in generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.doctype-system" select="''"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the system identifier that should be used by
the chunking stylesheet in the document type declaration of chunked pages.
Not all processors support specification of
this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.encoding</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.encoding</refname>
<refpurpose>Encoding used in generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.encoding" select="'ISO-8859-1'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the encoding to be used in files
generated by the chunking stylesheet. Not all processors support
specification of this parameter.
</para>

<para>This parameter used to be named <literal>default.encoding</literal>.</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.indent</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.indent</refname>
<refpurpose>Specification of indentation on generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.indent" select="'no'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the value of the indent
specification for generated pages. Not all processors support
specification of this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.media-type</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.media-type</refname>
<refpurpose>Media type to use in generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.media-type" select="''"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the media type that should be used by
the chunking stylesheet. Not all processors support specification of
this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.method</refentrytitle>
<refmiscinfo role="type">list</refmiscinfo>
<refmiscinfo role="value">html</refmiscinfo>
<refmiscinfo role="value">xml</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.method</refname>
<refpurpose>Method used in generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.method" select="'html'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the output method to be used in files
generated by the chunking stylesheet.
</para>

<para>This parameter used to be named <literal>output.method</literal>.</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.omit-xml-declaration</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>chunker.output.omit-xml-declaration</refname>
<refpurpose>Omit-xml-declaration for generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.omit-xml-declaration" select="'no'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the value of the omit-xml-declaration
specification for generated pages. Not all processors support
specification of this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>chunker.output.standalone</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunker.output.standalone</refname>
<refpurpose>Standalone declaration for generated pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="chunker.output.standalone" select="'no'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies the value of the standalone
specification for generated pages. Not all processors support
specification of this parameter.
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>saxon.character.representation</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>saxon.character.representation</refname>
<refpurpose>Saxon character representation used in generated HTML pages</refpurpose>
</refnamediv><refsynopsisdiv>&lt;xsl:param name="saxon.character.representation" select="'entity;decimal'"/&gt;
</refsynopsisdiv><refsect1><title>Description</title>

<para>This character representation is used in files generated by chunking stylesheet. If
you want to suppress entity references for characters with direct representation 
in default.encoding, set this parameter to value <literal>native</literal>. 
</para>

<note>
<para>This parameter is documented here, but the declaration is actually
in the <filename>chunker.xsl</filename> stylesheet module.</para>
</note>

</refsect1>
</doc:refentry>


<doc:refentry><refmeta>
<refentrytitle>html.ext</refentrytitle>

</refmeta><refnamediv>
<refname>html.ext</refname>
<refpurpose>Identifies the extension of generated HTML files</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The extension identified by <parameter>html.ext</parameter> will
be used as the filename extension for chunks created by this stylesheet.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.ext" select="'.html'"/>

<doc:refentry><refmeta>
<refentrytitle>use.id.as.filename</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>use.id.as.filename</refname>
<refpurpose>Use ID value of chunk elements as the filename?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If <parameter>use.id.as.filename</parameter>
is non-zero, the filename of chunk elements that have IDs will be
derived from the ID value.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="use.id.as.filename" select="'0'"/>

<doc:refentry><refmeta>
<refentrytitle>html.extra.head.links</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>html.extra.head.links</refname>
<refpurpose>Toggle extra HTML head link information</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, extra <sgmltag>link</sgmltag> elements will be
generated in the <sgmltag>head</sgmltag> of chunked HTML files. These
extra links point to chapters, appendixes, sections, etc. as supported
by the <quote>Site Navigation Bar</quote> in Mozilla 1.0 (as of CR1, at least).
</para>

</refsect1>
</doc:refentry>
<xsl:param name="html.extra.head.links" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>root.filename</refentrytitle>

</refmeta><refnamediv>
<refname>root.filename</refname>
<refpurpose>Identifies the name of the root HTML file when chunking</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>root.filename</parameter> is the base filename for
the chunk created for the root of each document processed.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="root.filename" select="'index'"/>

<doc:refentry><refmeta>
<refentrytitle>base.dir</refentrytitle>

</refmeta><refnamediv>
<refname>base.dir</refname>
<refpurpose>The base directory of chunks</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If specified, the <literal>base.dir</literal> identifies
the output directory for chunks. (If not specified, the output directory
is system dependent.)</para>

</refsect1>
</doc:refentry>
<xsl:param name="base.dir" select="''"/>

<doc:refentry><refmeta>
    <refentrytitle>generate.manifest</refentrytitle>
    <refmiscinfo role="type">boolean</refmiscinfo>
  </refmeta><refnamediv>
    <refname>generate.manifest</refname>
    <refpurpose>Generate a manifest file?</refpurpose>
  </refnamediv><refsynopsisdiv>
    
  </refsynopsisdiv><refsect1><title>Description</title>

    <para>If non-zero, a list of HTML files generated by the
      stylesheet transformation is written to the file named by
      the <parameter>manifest</parameter> parameter.</para>

  </refsect1>
</doc:refentry>
<xsl:param name="generate.manifest" select="0"/>

<doc:refentry><refmeta>
    <refentrytitle>manifest</refentrytitle>
    <refmiscinfo role="type">string</refmiscinfo>
  </refmeta><refnamediv>
    <refname>manifest</refname>
    <refpurpose>Name of manifest file</refpurpose>
  </refnamediv><refsynopsisdiv>
    
  </refsynopsisdiv><refsect1><title>Description</title>

    <para>The name of the file to which a manifest is written (if the
      value of the <parameter>generate.manifest</parameter> parameter
      is non-zero).</para>

  </refsect1>
</doc:refentry>
<xsl:param name="manifest" select="'HTML.manifest'"/>

<doc:refentry><refmeta>
<refentrytitle>manifest.in.base.dir</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>manifest.in.base.dir</refname>
<refpurpose>Should be manifest file written in $base.dir?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero manifest file and project files for HTML Help and
Eclipse Help are written into <parameter>base.dir</parameter> instead
of current directory.</para>

</refsect1>
</doc:refentry>
<xsl:param name="manifest.in.base.dir" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.toc</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>chunk.toc</refname>
<refpurpose>An explicit TOC to be used for chunking</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>chunk.toc</parameter> identifies an explicit TOC that
will be used for chunking. This parameter is only used by the
<filename>chunktoc.xsl</filename> stylesheet (and customization layers built
from it).</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.toc" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.tocs.and.lots</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>chunk.tocs.and.lots</refname>
<refpurpose>Should ToC and LoTs be in separate chunks?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, ToC and LoT (List of Examples, List of Figures, etc.)
will be put in a separate chunk. At the moment, this chunk is not in the
normal forward/backward navigation list. Instead, a new link is added to the
navigation footer.</para>

<para>This feature is still somewhat experimental. Feedback welcome.</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.tocs.and.lots" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.separate.lots</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>chunk.separate.lots</refname>
<refpurpose>Should each LoT be in its own separate chunk?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, each of the ToC and LoTs
(List of Examples, List of Figures, etc.)
will be put in its own separate chunk.
The title page includes generated links to each of the separate files.
</para>
<para>
This feature depends on the
<literal>chunk.tocs.and.lots</literal>
parameter also being non-zero. 
</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.separate.lots" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.tocs.and.lots.has.title</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>chunk.tocs.and.lots.has.title</refname>
<refpurpose>Should ToC and LoTs in a separate chunks have title?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero title of document is shown before ToC/LoT in
separate chunk.</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.tocs.and.lots.has.title" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.section.depth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>chunk.section.depth</refname>
<refpurpose>Depth to which sections should be chunked</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter sets the depth of section chunking.</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.section.depth" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.first.sections</refentrytitle>

</refmeta><refnamediv>
<refname>chunk.first.sections</refname>
<refpurpose>Chunk the first top-level section?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, a chunk will be created for the first top-level
<sgmltag>sect1</sgmltag> or <sgmltag>section</sgmltag> elements in
each component. Otherwise, that section will be part of the chunk for
its parent.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.first.sections" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>chunk.quietly</refentrytitle>

</refmeta><refnamediv>
<refname>chunk.quietly</refname>
<refpurpose>Omit the chunked filename messages.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If zero (the default), the XSL processor emits a message naming
each separate chunk filename as it is being output.
If nonzero, then the messages are suppressed.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="chunk.quietly" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>navig.graphics</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>navig.graphics</refname>
<refpurpose>Use graphics in navigational headers and footers?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero), the navigational headers and footers in chunked
HTML are presented in an alternate style that uses
graphical icons for Next, Previous, Up, and Home.
Default graphics are provided in the distribution.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="navig.graphics" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>navig.graphics.extension</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>navig.graphics.extension</refname>
<refpurpose>Extension for navigational graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the filename extension to use on navigational graphics used
in the headers and footers of chunked HTML.</para>

</refsect1>
</doc:refentry>
<xsl:param name="navig.graphics.extension" select="'.gif'"/>

<doc:refentry><refmeta>
<refentrytitle>navig.graphics.path</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>navig.graphics.path</refname>
<refpurpose>Path to navigational graphics</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Sets the path, probably relative to the directory where the HTML
files are created, to the navigational graphics used in the
headers and footers of chunked HTML.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="navig.graphics.path">images/</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>navig.showtitles</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>navig.showtitles</refname>
<refpurpose>Display titles in HTML headers and footers?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If true (non-zero),
the headers and footers of chunked HTML
display the titles of the next and previous chunks,
along with the words 'Next' and 'Previous' (or the
equivalent graphical icons if navig.graphics is true).
If false (zero), then only the words 'Next' and 'Previous'
(or the icons) are displayed.
</para>

</refsect1>
</doc:refentry>
<xsl:param name="navig.showtitles">1</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>profile.arch</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.arch</refname>
<refpurpose>Target profile for <sgmltag class="attribute">arch</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.arch" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.condition</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.condition</refname>
<refpurpose>Target profile for <sgmltag class="attribute">condition</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.condition" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.conformance</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.conformance</refname>
<refpurpose>Target profile for <sgmltag class="attribute">conformance</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.conformance" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.lang</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.lang</refname>
<refpurpose>Target profile for <sgmltag class="attribute">lang</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.lang" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.os</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.os</refname>
<refpurpose>Target profile for <sgmltag class="attribute">os</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.os" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.revision</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.revision</refname>
<refpurpose>Target profile for <sgmltag class="attribute">revision</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.revision" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.revisionflag</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.revisionflag</refname>
<refpurpose>Target profile for <sgmltag class="attribute">revisionflag</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.revisionflag" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.role</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.role</refname>
<refpurpose>Target profile for <sgmltag class="attribute">role</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

<warning>
<para>Note that <sgmltag class="attribute">role</sgmltag> is often
used for other purposes than profiling. For example it is commonly
used to get emphasize in bold font:</para>

<programlisting>&lt;emphasis role="bold"&gt;very important&lt;/emphasis&gt;</programlisting>

<para>If you are using <sgmltag class="attribute">role</sgmltag> for
these purposes do not forget to add values like <literal>bold</literal> to
value of this parameter. If you forgot you will get document with
small pieces missing which are very hard to track.</para>

<para>For this reason it is not recommended to use <sgmltag class="attribute">role</sgmltag> attribute for profiling. You should
rather use profiling specific attributes like <sgmltag class="attribute">userlevel</sgmltag>, <sgmltag class="attribute">os</sgmltag>, <sgmltag class="attribute">arch</sgmltag>, <sgmltag class="attribute">condition</sgmltag>, etc.</para>
</warning>

</refsect1>
</doc:refentry>
<xsl:param name="profile.role" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.security</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.security</refname>
<refpurpose>Target profile for <sgmltag class="attribute">security</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.security" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.userlevel</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.userlevel</refname>
<refpurpose>Target profile for <sgmltag class="attribute">userlevel</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.userlevel" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.vendor</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.vendor</refname>
<refpurpose>Target profile for <sgmltag class="attribute">vendor</sgmltag>
attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.vendor" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.attribute</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.attribute</refname>
<refpurpose>Name of user-specified profiling attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter is used in conjuction with <link linkend="profile.value"><parameter>profile.value</parameter></link>.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.attribute" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.value</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.value</refname>
<refpurpose>Target profile for user-specified attribute</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When you are using this parameter you must also specify name of
profiling attribute with parameter <link linkend="profile.attribute"><parameter>profile.attribute</parameter></link>.</para>

<para>Value of this parameter specifies profiles which should be
included in the output. You can specify multiple profiles by
separating them by semicolon. You can change separator character by
<link linkend="profile.separator"><parameter>profile.separator</parameter></link>
parameter.</para>

<para>This parameter has effect only when you are using profiling
stylesheets (<filename>profile-docbook.xsl</filename>,
<filename>profile-chunk.xsl</filename>, …) instead of normal
ones (<filename>docbook.xsl</filename>,
<filename>chunk.xsl</filename>, …).</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.value" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>profile.separator</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>profile.separator</refname>
<refpurpose>Separator character for compound profile values</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Separator character for compound profile values.</para>

</refsect1>
</doc:refentry>
<xsl:param name="profile.separator" select="';'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.encoding</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.encoding</refname>
<refpurpose>Character encoding to use in files for HTML Help compiler.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>HTML Help Compiler is not UTF-8 aware, so you should always use
apropriate single-byte encoding here.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.encoding" select="'iso-8859-1'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.autolabel</refname>
<refpurpose>Should tree-like ToC use autonumbering feature?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want to include chapter and section numbers into ToC in
the left panel, set this parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.autolabel" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.chm</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.chm</refname>
<refpurpose>Filename of output HTML Help file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of result
CHM file than htmlhelp.chm.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.chm" select="'htmlhelp.chm'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.default.topic</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.default.topic</refname>
<refpurpose>Name of file with default topic</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Normally first chunk of document is displayed when you open HTML
Help file. If you want to display another topic, simply set its
filename by this parameter.</para>

<para>This is useful especially if you don't generate ToC in front of
your document and you also hide root element in ToC. E.g.:</para>

<programlisting>&lt;xsl:param name="generate.book.toc" select="0"/&gt;
&lt;xsl:param name="htmlhelp.hhc.show.root" select="0"/&gt;
&lt;xsl:param name="htmlhelp.default.topic" select="'pr01.html'"/&gt;</programlisting>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.default.topic" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.display.progress</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.display.progress</refname>
<refpurpose>Display compile progress?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>You can swith off display of compile progress by setting this
parameter to 0.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.display.progress" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhp</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhp</refname>
<refpurpose>Filename of project file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of project
file than htmlhelp.hhp.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhp" select="'htmlhelp.hhp'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhc</refname>
<refpurpose>Filename of TOC file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of TOC file
than toc.hhc.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc" select="'toc.hhc'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhk</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhk</refname>
<refpurpose>Filename of index file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of index file
than index.hhk.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhk" select="'index.hhk'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhp.tail</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhp.tail</refname>
<refpurpose>Additional content for project file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want to include some additional parameters into project file,
store appropriate part of project file into this parameter.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhp.tail"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhp.window</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhp.window</refname>
<refpurpose>Name of default window.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Name of default window. If empty no [WINDOWS] section will be
added to project file.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhp.window" select="'Main'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhp.windows</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhp.windows</refname>
<refpurpose>Definition of additional windows</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Content of this parameter is placed at the end of [WINDOWS]
section of project file. You can use it for defining your own
addtional windows.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhp.windows"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.enhanced.decompilation</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.enhanced.decompilation</refname>
<refpurpose>Allow enhanced decompilation of CHM?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>When set to 1 this parameter enables enhanced decompilation of CHM.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.enhanced.decompilation" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.enumerate.images</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.enumerate.images</refname>
<refpurpose>Should be paths to all used images added to project file?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>You should turn on this flag, if you insert images into your documents 
as external binary entities or if you are using absolute path in image names.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.enumerate.images" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.force.map.and.alias</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.force.map.and.alias</refname>
<refpurpose>Should be [MAP] and [ALIAS] section added to project file unconditionaly?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>You should turn on this flag, if you have your own
<filename>alias.h</filename> and <filename>contex.h</filename> files
and you want include reference to them in project file.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.force.map.and.alias" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.map.file</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.map.file</refname>
<refpurpose>Filename of map file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of map file
than <filename>context.h</filename>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.map.file" select="'context.h'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.alias.file</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.alias.file</refname>
<refpurpose>Filename of map file.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want different name of map file
than <filename>alias.h</filename>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.alias.file" select="'alias.h'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc.section.depth</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhc.section.depth</refname>
<refpurpose>Depth of TOC for sections in a left pane.</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Change this parameter if you want shallower ToC in a left pane
of HTML Help viewer.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc.section.depth" select="5"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc.show.root</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhc.show.root</refname>
<refpurpose>Should be entry for root element shown in ToC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If set to 0, there will be no entry for root element in
ToC. This is useful when you want provide user with expanded ToC as
a default.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc.show.root" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc.folders.instead.books</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>htmlhelp.hhc.folders.instead.books</refname>
<refpurpose>Use folder icons in ToC (instead of book icons)?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter controls whether there should be folder-like
icons (1) or book-like icons (0) in ToC. If you want to use
folder-like icons you must swith off binary ToC using
<parameter>htmlhelp.hhc.binary</parameter>.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc.folders.instead.books" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc.binary</refentrytitle>
<refmiscinfo role="type"/>
</refmeta><refnamediv>
<refname>htmlhelp.hhc.binary</refname>
<refpurpose>Generate binary ToC?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parametr controls whether binary TOC will be generated. You
must create binary TOC if you want to add Prev/Next buttons to toolbar
(which is default behaviour). Files with binary TOC can't be merged.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc.binary" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.hhc.width</refentrytitle>
<refmiscinfo role="type">integer</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.hhc.width</refname>
<refpurpose>Width of navigation (ToC) pane</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies width of ToC pane in pixels.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.hhc.width"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.title</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.title</refname>
<refpurpose>Title of HTML Help</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Content of this parameter will be used as a title for generated
HTML Help. If empty, title will be automatically taken from document.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.title" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.show.menu</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.show.menu</refname>
<refpurpose>Should be menu shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want application menu in your HTML Help file, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.show.menu" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.show.toolbar.text</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.show.toolbar.text</refname>
<refpurpose>Show text under toolbar buttons?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>You can switch off display of texts under toolbar buttons by
setting this parameter to 0.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.show.toolbar.text" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.show.advanced.search</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.show.advanced.search</refname>
<refpurpose>Should be advanced search available?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want advanced search features in your help, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.show.advanced.search" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.show.favorities</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.show.favorities</refname>
<refpurpose>Should be favorities tab shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want favorities tab shown in your help, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.show.favorities" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.hideshow</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.hideshow</refname>
<refpurpose>Should be Hide/Show button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Hide/Show button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.hideshow" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.back</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.back</refname>
<refpurpose>Should be Back button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Back button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.back" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.forward</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.forward</refname>
<refpurpose>Should be Forward button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Forward button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.forward" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.stop</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.stop</refname>
<refpurpose>Should be Stop button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Stop button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.stop" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.refresh</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.refresh</refname>
<refpurpose>Should be Refresh button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Refresh button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.refresh" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.home</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.home</refname>
<refpurpose>Should be Home button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Home button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.home" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.home.url</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.home.url</refname>
<refpurpose>URL address of page accessible by Home button</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>URL address of page accessible by Home button.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.home.url"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.options</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.options</refname>
<refpurpose>Should be Options button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Options button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.options" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.print</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.print</refname>
<refpurpose>Should be Print button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Print button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.print" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.locate</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.locate</refname>
<refpurpose>Should be Locate button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Locate button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.locate" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump1</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump1</refname>
<refpurpose>Should be Jump1 button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Jump1 button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump1" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump1.url</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump1.url</refname>
<refpurpose>URL address of page accessible by Jump1 button</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>URL address of page accessible by Jump1 button.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump1.url"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump1.title</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump1.title</refname>
<refpurpose>Title of Jump1 button</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Title of Jump1 button.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump1.title" select="'User1'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump2</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump2</refname>
<refpurpose>Should be Jump2 button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Jump2 button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump2" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump2.url</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump2.url</refname>
<refpurpose>URL address of page accessible by Jump2 button</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>URL address of page accessible by Jump2 button.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump2.url"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.jump2.title</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.jump2.title</refname>
<refpurpose>Title of Jump2 button</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Title of Jump2 button.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.jump2.title" select="'User2'"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.next</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.next</refname>
<refpurpose>Should be Next button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Next button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.next" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.prev</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.prev</refname>
<refpurpose>Should be Prev button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Prev button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.prev" select="1"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.button.zoom</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.button.zoom</refname>
<refpurpose>Should be Zoom button shown?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want Zoom button shown on toolbar, turn this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.button.zoom" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.remember.window.position</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.remember.window.position</refname>
<refpurpose>Remember help window position?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>To remember help window position between starts set this
parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.remember.window.position" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.window.geometry</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.window.geometry</refname>
<refpurpose>Set initial geometry of help window</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>This parameter specifies initial position of help
window. E.g.</para>

<programlisting>&lt;xsl:param name="htmlhelp.window.geometry"&gt;[160,64,992,704]&lt;/xsl:param&gt;</programlisting>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.window.geometry"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.use.hhk</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.use.hhk</refname>
<refpurpose>Should be index built using HHK file?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, index is created using HHK file. This provides some
new features.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.use.hhk" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>htmlhelp.only</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>htmlhelp.only</refname>
<refpurpose>Should be only project files generated?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want to play with various HTML Help parameters and you
don't need to regenerate all HTML files, you can set this parameter to
1. This setting will not process whole document, only project files
(hhp, hhc, hhk,...) will be generated.</para>

</refsect1>
</doc:refentry>
<xsl:param name="htmlhelp.only" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>eclipse.autolabel</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>eclipse.autolabel</refname>
<refpurpose>Should tree-like ToC use autonumbering feature?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If you want to include chapter and section numbers into ToC in
the left panel, set this parameter to 1.</para>

</refsect1>
</doc:refentry>
<xsl:param name="eclipse.autolabel" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>eclipse.plugin.name</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>eclipse.plugin.name</refname>
<refpurpose>Eclipse Help plugin name</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Eclipse Help plugin name.</para>

</refsect1>
</doc:refentry>
<xsl:param name="eclipse.plugin.name">DocBook Online Help Sample</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>eclipse.plugin.id</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>eclipse.plugin.id</refname>
<refpurpose>Eclipse Help plugin id</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Eclipse Help plugin id. You should change this id to something
unique for each help.</para>

</refsect1>
</doc:refentry>
<xsl:param name="eclipse.plugin.id">com.example.help</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>eclipse.plugin.provider</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>eclipse.plugin.provider</refname>
<refpurpose>Eclipse Help plugin provider name</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>Eclipse Help plugin provider name.</para>

</refsect1>
</doc:refentry>
<xsl:param name="eclipse.plugin.provider">Example provider</xsl:param>

<doc:refentry><refmeta>
<refentrytitle>l10n.gentext.language</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>l10n.gentext.language</refname>
<refpurpose>Sets the gentext language</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If this parameter is set to any value other than the empty string, its
value will be used as the value for the language when generating text. Setting
<parameter>l10n.gentext.language</parameter> overrides any settings within the
document being formatted.</para>

<para>It's much more likely that you might want to set the
<parameter>l10n.gentext.default.language</parameter> parameter.</para>

</refsect1>
</doc:refentry>
<xsl:param name="l10n.gentext.language" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>l10n.gentext.default.language</refentrytitle>
<refmiscinfo role="type">string</refmiscinfo>
</refmeta><refnamediv>
<refname>l10n.gentext.default.language</refname>
<refpurpose>Sets the default language for generated text</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The value of the <parameter>l10n.gentext.default.language</parameter>
parameter is used as the language for generated text if no setting is provided
in the source document.</para>

</refsect1>
</doc:refentry>
<xsl:param name="l10n.gentext.default.language" select="'en'"/>

<doc:refentry><refmeta>
<refentrytitle>l10n.gentext.use.xref.language</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>l10n.gentext.use.xref.language</refname>
<refpurpose>Use the language of target when generating cross-reference text?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, the language of the target will be used when
generating cross reference text. Usually, the <quote>current</quote>
language is used when generating text (that is, the language of the
element that contains the cross-reference element). But setting this parameter
allows the language of the element <emphasis>pointed to</emphasis> to control
the generated text.</para>

<para>Consider the following example:</para>

<informalexample>
<programlisting>&lt;para lang="en"&gt;See also &lt;xref linkend="chap3"/&gt;.&lt;/para&gt;
</programlisting>
</informalexample>

<para>Suppose that Chapter 3 happens to be written in German.
If <parameter>l10n.gentext.use.xref.language</parameter> is non-zero, the
resulting text will be something like this:</para>

<blockquote>
<para>See also Kapital 3.</para>
</blockquote>

<para>Where the more traditional rendering would be:</para>

<blockquote>
<para>See also Chapter 3.</para>
</blockquote>

</refsect1>
</doc:refentry>
<xsl:param name="l10n.gentext.use.xref.language" select="0"/>

<doc:refentry><refmeta>
<refentrytitle>l10n.lang.value.rfc.compliant</refentrytitle>
<refmiscinfo role="type">boolean</refmiscinfo>
</refmeta><refnamediv>
<refname>l10n.lang.value.rfc.compliant</refname>
<refpurpose>Make value of lang attribute RFC compliant?</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>If non-zero, ensure that the values for all <sgmltag class="attribute">lang</sgmltag> attributes in HTML output are RFC
compliant<footnote><para>Section 8.1.1, <ulink url="http://www.w3.org/TR/REC-html40/struct/dirlang.html#h-8.1.1">Language Codes</ulink>, in the HTML 4.0 Recommendation states that:

<blockquote><para>[RFC1766] defines and explains the language codes
that must be used in HTML documents.</para>
<para>Briefly, language codes consist of a primary code and a possibly
empty series of subcodes:

<literallayout class="monospaced">language-code = primary-code ( "-" subcode )*</literallayout>
</para>
<para>And in RFC 1766, <ulink url="http://www.ietf.org/rfc/rfc1766.txt">Tags for the Identification
of Languages</ulink>, the EBNF for "language tag" is given as:

<literallayout class="monospaced">Language-Tag = Primary-tag *( "-" Subtag )
Primary-tag = 1*8ALPHA
Subtag = 1*8ALPHA</literallayout>
</para>
</blockquote>
</para></footnote>.

by taking any underscore characters in any <sgmltag class="attribute">lang</sgmltag> values found in source documents, and
replacing them with hyphen characters in output HTML files. For
example, <literal>zh_CN</literal> in a source document becomes
<literal>zh-CN</literal> in the HTML output form that source.

<note>
<para>This parameter does not cause any case change in <sgmltag class="attribute">lang</sgmltag> values, because RFC 1766
explicitly states that all "language tags" (as it calls them) "are
to be treated as case insensitive".</para>
</note>
</para>

</refsect1>
</doc:refentry>
<xsl:param name="l10n.lang.value.rfc.compliant" select="1"/>
</xsl:stylesheet>