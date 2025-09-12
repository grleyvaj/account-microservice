-- Insertar cliente de prueba
INSERT INTO "customers" (
    "client_id",
    "name",
    "is_deleted",
    "created_at",
    "updated_at",
    "deleted_at"
) VALUES (
    'XAXX010101000',
    'Test Customer',
    false,
    NOW(),
    NULL,
    NULL
)
ON CONFLICT (client_id) DO NOTHING;