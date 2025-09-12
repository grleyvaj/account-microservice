CREATE TABLE IF NOT EXISTS "accounts" (
    "id" varchar(26) PRIMARY KEY,
    "client_id" VARCHAR(255) NOT NULL,
    "account_number" VARCHAR(255) NOT NULL,
    "account_type" VARCHAR(255) NOT NULL,
    "home_balance" NUMERIC(20,5) NOT NULL,
    "available_balance" NUMERIC(20,5),
    "alias" VARCHAR(255),
    "version" BIGINT NOT NULL DEFAULT 0,
    "is_active" BOOLEAN NOT NULL DEFAULT true,
    "is_deleted" BOOLEAN NOT NULL DEFAULT false,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP,
    "deleted_at" TIMESTAMP,

    CONSTRAINT "fk_accounts_customer" FOREIGN KEY ("client_id") REFERENCES "customers"("client_id"),
    CONSTRAINT "uk_accounts_account_number" UNIQUE ("account_number")
);

CREATE INDEX IF NOT EXISTS "idx_accounts_client_id" ON "accounts"("client_id");
CREATE INDEX IF NOT EXISTS "idx_accounts_type" ON "accounts"("account_type");