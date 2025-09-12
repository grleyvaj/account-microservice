CREATE TABLE IF NOT EXISTS "movements" (
    "id" varchar(26) PRIMARY KEY,
    "account_id" VARCHAR(26) NOT NULL,
    "client_id" VARCHAR(26) NOT NULL,
    "execution_date" TIMESTAMP NOT NULL,
    "movement_type" VARCHAR(255) NOT NULL,
    "amount" NUMERIC(20,5) NOT NULL,
    "balance_before" NUMERIC(20,5) NOT NULL,
    "balance_after" NUMERIC(20,5) NOT NULL,
    "is_active" BOOLEAN NOT NULL DEFAULT true,
    "is_deleted" BOOLEAN NOT NULL DEFAULT false,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP,
    "deleted_at" TIMESTAMP,

    CONSTRAINT "fk_movements_account" FOREIGN KEY ("account_id") REFERENCES "accounts"("id"),
    CONSTRAINT "fk_movements_customers" FOREIGN KEY ("client_id") REFERENCES "customers"("client_id")
);

CREATE INDEX IF NOT EXISTS "idx_movements_account_date" ON "movements"("account_id", "execution_date" DESC);
CREATE INDEX IF NOT EXISTS "idx_movements_account_id" ON "movements"("account_id");
CREATE INDEX IF NOT EXISTS "idx_movements_type" ON "movements"("movement_type");