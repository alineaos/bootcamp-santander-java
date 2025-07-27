ALTER TABLE accesses
    ADD COLUMN crete_data boolean default false,
    ADD COLUMN read_data boolean default false,
    ADD COLUMN update_data boolean default false,
    ADD COLUMN delete_data boolean default false;
