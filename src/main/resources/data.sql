CREATE TABLE IF NOT EXISTS employee (
                                        id UUID PRIMARY KEY,
                                        first_name VARCHAR(255),
                                        last_name VARCHAR(255),
                                        salary DOUBLE PRECISION,
                                        email VARCHAR(255),
                                        designation VARCHAR(255),
                                        created_at TIMESTAMP
);

INSERT INTO employee (id, first_name, last_name, salary, email, designation, created_at)
VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'John', 'Doe', 60000.00, 'john.doe@example.com', 'Software Engineer', '2024-03-14 10:15:00'),
    ('660e8400-e29b-41d4-a716-446655440001', 'Jane', 'Smith', 75000.00, 'jane.smith@example.com', 'Project Manager', '2024-03-14 10:20:00'),
    ('770e8400-e29b-41d4-a716-446655440002', 'Alice', 'Johnson', 50000.00, 'alice.johnson@example.com', 'QA Engineer', '2024-03-14 10:25:00'),
    ('880e8400-e29b-41d4-a716-446655440003', 'Bob', 'Brown', 80000.00, 'bob.brown@example.com', 'DevOps Engineer', '2024-03-14 10:30:00'),
    ('990e8400-e29b-41d4-a716-446655440004', 'Charlie', 'Davis', 55000.00, 'charlie.davis@example.com', 'Data Analyst', '2024-03-14 10:35:00');
