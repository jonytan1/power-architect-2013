<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:doc="http://nwalsh.com/xsl/documentation/1.0" xmlns:src="http://nwalsh.com/xmlns/litprog/fragment" exclude-result-prefixes="src" version="1.0">

<!-- This file is generated from param.xweb; do not edit this file! -->
<!-- ********************************************************************
     $Id: param.xsl 903 2006-06-21 22:32:15Z johnson $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://nwalsh.com/docbook/xsl/ for copyright
     and other information.

     ******************************************************************** -->

<doc:refentry><refmeta>
<refentrytitle>wordml.template</refentrytitle>
</refmeta><refnamediv>
<refname>wordml.template</refname>
<refpurpose>Specify the template WordML document</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>wordml.template</parameter> parameter specifies a WordML document to use as a template for the generated document.  The template document is used to define the (extensive) headers for the generated document, in particular the paragraph and character styles that are used to format the various elements.  Any content in the template document is ignored.</para>

<para>A template document is used in order to allow maintenance of the paragraph and character styles to be done using Word itself, rather than these XSL stylesheets.</para>

</refsect1>
</doc:refentry>
<xsl:param name="wordml.template" select="''"/>

<doc:refentry><refmeta>
<refentrytitle>pages.template</refentrytitle>
</refmeta><refnamediv>
<refname>pages.template</refname>
<refpurpose>Specify the template Pages document</refpurpose>
</refnamediv><refsynopsisdiv>

</refsynopsisdiv><refsect1><title>Description</title>

<para>The <parameter>pages.template</parameter> parameter specifies a Pages (the Apple word processing application) document to use as a template for the generated document.  The template document is used to define the (extensive) headers for the generated document, in particular the paragraph and character styles that are used to format the various elements.  Any content in the template document is ignored.</para>

<para>A template document is used in order to allow maintenance of the paragraph and character styles to be done using Pages itself, rather than these XSL stylesheets.</para>

</refsect1>
</doc:refentry>
<xsl:param name="pages.template" select="''"/>
</xsl:stylesheet>