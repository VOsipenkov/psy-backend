-- Совместимо с H2 (без INTERVAL!)
INSERT INTO users (id, login, password) VALUES
    ('000e8400-e29b-41d3-a716-446655440000', 'vlad', 'password123');

INSERT INTO chat (id, user_id, name, created_at) VALUES
    ('00000000-0000-0000-0000-000000000000',
     '000e8400-e29b-41d3-a716-446655440000', 'Первый сон', CURRENT_TIMESTAMP);

INSERT INTO chat (id, user_id, name, created_at) VALUES
    ('10000000-0000-0000-0000-000000000000',
     '000e8400-e29b-41d3-a716-446655440000', 'Второй сон', CURRENT_TIMESTAMP);

INSERT INTO chat (id, user_id,name, created_at) VALUES
    ('20000000-0000-0000-0000-000000000000',
     '000e8400-e29b-41d3-a716-446655440000', 'Третий сон', CURRENT_TIMESTAMP);

INSERT INTO chat_messages (id, text, is_user, chat_id, user_id, created_at) VALUES
                                                                                (NEXTVAL('message_seq'), 'Привет! Расскажи о своём сне.', false,
                                                                                 '00000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Мне снилось, что я лечу.', true,
                                                                                 '00000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Очень хорошо - это говорит от твоем росте как личность.', false,
                                                                                 '00000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP);

INSERT INTO chat_messages (id, text, is_user, chat_id, user_id, created_at) VALUES
                                                                                (NEXTVAL('message_seq'), 'Привет! "Это второй сон".', false,
                                                                                 '10000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Мне приснился комарик.', true,
                                                                                 '10000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Очень хорошо - добрый сон.', false,
                                                                                 '10000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP);

INSERT INTO chat_messages (id, text, is_user, chat_id, user_id, created_at) VALUES
                                                                                (NEXTVAL('message_seq'), 'Привет! "Это третий сон".', false,
                                                                                 '20000000-0000-0000-0000-000000000000', '000e8400-e29b-41d3-a716-446655440000',
                                                                                 CURRENT_TIMESTAMP);