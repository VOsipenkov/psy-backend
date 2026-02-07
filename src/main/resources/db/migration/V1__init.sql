create table chat (id uuid not null, created_at timestamp(6) with time zone, user_id uuid, primary key (id));
create table chat_messages (id bigint not null, created_at timestamp(6) with time zone not null, is_user boolean not null, text varchar(255) not null, chat_id uuid, user_id uuid, primary key (id));
create table users (id uuid not null, login varchar(255) not null, password varchar(255), primary key (id));
create sequence message_seq start with 1 increment by 1;
alter table if exists chat_messages add constraint FKb27mi3082eolv7k6tavhgq3wc foreign key (chat_id) references chat;
alter table if exists chat_messages add constraint FK6f0y4l43ihmgfswkgy9yrtjkh foreign key (user_id) references users;