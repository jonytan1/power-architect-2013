The SQL Power Architect Community Edition is a cross-platform, open-source data modeling tool with a GUI and an embeddable API.

For more information on the Community or Enterprise Edition of SQL Power Architect, please visit http://www.sqlpower.ca/page/architect

This project is the follow-up version of the project power-architect(http://code.google.com/p/power-architect/)


---

## **New Features in future** ##
  * Support views, store procedures etc

# **SQL Power Architect 1.0.8 Released!** #
The SQL Power Architect 1.0.8 has been released since 2013/07/23.
Source code can be downloaded from:<br>
svn checkout <a href='http://power-architect-2013.googlecode.com/svn/tags/release-1.0.8-rc2/architect2013'>http://power-architect-2013.googlecode.com/svn/tags/release-1.0.8-rc2/architect2013</a> and<br>
svn checkout <a href='http://power-architect-2013.googlecode.com/svn/tags/release-1.0.8-rc2/sqlpower-library2013'>http://power-architect-2013.googlecode.com/svn/tags/release-1.0.8-rc2/sqlpower-library2013</a>

<h2><b>Bug Fixed</b>(SQL Power Architect 1.0.8 )</h2>
<ul><li>Fixed since 2013/07/27: <a href='http://code.google.com/p/power-architect-2013/issues/detail?id=1'>http://code.google.com/p/power-architect-2013/issues/detail?id=1</a></li></ul>

<h2><b>New Features</b>(SQL Power Architect 1.0.8 )</h2>
<ul><li>Support multi-schema<br>
</li><li>Support to sort tables list in DBTree of playpen database by name or logical name<br>
<b>新特性</b>
</li><li>支持multi-schema<br>
</li><li>playpen database的DBTree中的表列表可以按表名/逻辑名排序</li></ul>

<h1><b>SQL Power Architect 1.0.7 Released!</b></h1>
The SQL Power Architect 1.0.7 has been released since 2013/02/20.<br>
Source code can be downloaded from:<br>
svn checkout <a href='http://power-architect-2013.googlecode.com/svn/tags/release-1.0.7-rc/architect2013'>http://power-architect-2013.googlecode.com/svn/tags/release-1.0.7-rc/architect2013</a> and<br>
svn checkout <a href='http://power-architect-2013.googlecode.com/svn/tags/release-1.0.7-rc/sqlpower-library2013'>http://power-architect-2013.googlecode.com/svn/tags/release-1.0.7-rc/sqlpower-library2013</a>

<h2><b>New Features</b>(SQL Power Architect 1.0.7 )</h2>
<ul><li>Save/Load logical name into/from Microsoft SQL Server/MySQL Database<br>
</li><li>Support Simplified Chinese<br>
</li><li>Show non-nullable info in playpen and dbtree<br>
</li><li>Deprecated the "physical name" property of SQLObject(include SQLTable/SQLColumn...).<br>
<blockquote>In 1.0.6, sometimes the "name" property is used as "physical name" and at other times it is used as "logical name".<br>
</blockquote></li><li>Add new property "logical name"<br>
</li><li>On project setting panel, refresh the render of the dbtree node immediately when we apply the change to display physical name or logical name of tables / columns.<br>
<b>新特性</b>
</li><li>可以在MS SQL Server/MySQL 中保存/读取逻辑名<br>
</li><li>增加中文翻译<br>
</li><li>在playpen区域和左侧树列中显示非空情况<br>
</li><li>取消SQLObject的"physical name"属性，物理名称使用"name"属性。而不是像1.0.6那样name有时用作"physical name"，而有时用作"logical name"<br>
</li><li>SQLObject增加新属性"logical name"<br>
</li><li>在项目参数成功修改后，左侧树列中会自动收起，在重新打开后，已经切换显示“物理名”或者“逻辑名”。<br>
<b>Bug Fixes</b>
</li><li>Throw <code>NullPointerException</code> after generate database info from Database, for example MySQL</li></ul>

<hr />
For SQL Power Architect 1.0.6 and older releases, please refer to: <br><a href='http://code.google.com/p/power-architect/'>http://code.google.com/p/power-architect/</a> and <br><a href='http://code.google.com/p/sqlpower-library/'>http://code.google.com/p/sqlpower-library/</a>