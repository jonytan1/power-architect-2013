# About to support multiple schema

# Req #

  * Playpen database of each project can own many schemas.
  * Each project has only one schema as default.
  * When a table is creating, its schema is not defined, and playpen database has no schema, then system will create a schema named "default" as default schema and it will be the parent of the table.
  * When a new table is creating, its parent is not defined, and playpen database has a default schema, then the parent of the table is this default schema.
  * When a new table is creating, its parent is defined, and this schema is not exist in playpen database, then system will create this schema.
  * In DBTree, schemas are the sub nodes of the playpen database, and tables are the sub node of its parent -- schema.
  * The shcema name can not be duplicate.
  * The pop-up menu of "playpen database" tree note has a sub-menu named "Add Schema".
  * The pop-up menu of schema tree node in playpen database has a sub-menu named "Edit Schema"
  * The user can modify the schema of the table, when he/she is editing a table.



