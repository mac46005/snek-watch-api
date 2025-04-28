CREATE TABLE snake_types(
	id BIGSERIAL PRIMARY KEY,
	common_name VARCHAR(50) NOT NULL,
	taxonomy_name VARCHAR(50) NULL,
	care_level VARCHAR(50) NULL,
	overview VARCHAR(1000) NULL,
	average_life_span_in_yrs INTEGER NULL,
	average_adult_length_in_feet DOUBLE PRECISION NULL,
	diet VARCHAR(20)
);

CREATE TABLE snakes(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
	snake_type_id BIGINT NOT NULL,
	CONSTRAINT fk_snake_type
		FOREIGN KEY (snake_type_id)
		REFERENCES snake_types(id)
);

CREATE TABLE feeding_logs(
	id BIGSERIAL PRIMARY KEY,
	snake_id BIGINT NOT NULL,
	fed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	food_item VARCHAR(50) NULL,
	notes VARCHAR(500) NULL,
	CONSTRAINT fk_snake_id
		FOREIGN KEY (snake_id)
		REFERENCES snakes(id)
)