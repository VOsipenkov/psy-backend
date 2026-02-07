-- Совместимо с H2 (без INTERVAL!)
INSERT INTO users (id, login, password) VALUES
    ('00000000-0000-0000-0000-000000001111', 'vlad', 'password123');

INSERT INTO chat (id, user_id, created_at) VALUES
    ('00000000-0000-0000-0000-000000000000',
     '00000000-0000-0000-0000-000000001111', CURRENT_TIMESTAMP);

INSERT INTO chat_messages (id, text, is_user, chat_id, user_id, created_at) VALUES
                                                                                (NEXTVAL('message_seq'), 'Привет! Расскажи о своём сне.', false,
                                                                                 '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000001111',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Мне снилось, что я лечу.', true,
                                                                                 '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000001111',
                                                                                 CURRENT_TIMESTAMP),
                                                                                (NEXTVAL('message_seq'), 'Очень хорошо - это говорит от твоем росте как личность.', false,
                                                                                 '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000001111',
                                                                                 CURRENT_TIMESTAMP);