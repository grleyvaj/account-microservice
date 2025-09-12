CREATE TABLE IF NOT EXISTS "customers" (
    "client_id" VARCHAR(255) PRIMARY KEY,
    "name" VARCHAR(100) NOT NULL,
    "is_deleted" BOOLEAN NOT NULL DEFAULT false,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP,
    "deleted_at" TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS "idx_customers_client_id" ON "customers" ("client_id");
