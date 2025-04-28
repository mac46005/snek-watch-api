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