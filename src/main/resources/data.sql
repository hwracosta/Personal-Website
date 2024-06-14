--Query Set-up template--

-- Insert team members
INSERT INTO team_member (id, name) VALUES (1, 'Jaydee') ON CONFLICT (id) DO NOTHING;
INSERT INTO team_member (id, name) VALUES (2, 'Harry') ON CONFLICT (id) DO NOTHING;

-- Insert for Jaydee
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (1, 'Fireflies', 'Owl City', 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/f6/72/94/f67294c7-f123-c698-c70b-9e9aa1b0947f/09UMGIM22612.rgb.jpg/600x600bb.jpg', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (2, 'Yesterday', 'The Beatles', 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/1a/19/db/1a19db26-17ad-b986-11a9-f72ac7a6194b/18UMGIM31214.rgb.jpg/600x600bb.jpg', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (3, 'Dalla Dalla', 'ITZY', 'https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/b5/83/3f/b5833f11-e5e1-3f65-81f0-a69c5fe09499/192641939532_Cover.jpg/600x600bb.jpg', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (4, 'Thriller', 'Michael Jackson', 'https://is1-ssl.mzstatic.com/image/thumb/Music115/v4/32/4f/fd/324ffda2-9e51-8f6a-0c2d-c6fd2b41ac55/074643811224.jpg/600x600bb.jpg', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (5, 'To Zanarkand', 'Nobou Uematsu', 'https://is1-ssl.mzstatic.com/image/thumb/Features125/v4/68/c2/a8/68c2a8b3-7e94-e44c-3ecc-18788311f969/dj.bcvznqkk.jpg/600x600bb.jpg', 1) ON CONFLICT (id) DO NOTHING;

-- Insert for Harry
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (6, 'intro (end of the world)', 'Ariana Grande', 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/34/fe/a1/34fea184-6d20-3f50-b4ce-5e1501c1c5ab/24UMGIM00198.rgb.jpg/600x600bb.jpg', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (7, 'Bewitched', 'Laufey', 'https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/1f/de/6c/1fde6cb4-9703-c214-cdc6-8ecf7d0f0aa0/197189040030.jpg/600x600bb.jpg', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (8, 'What is Love', 'TWICE', 'https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/5d/8d/ae/5d8daec6-bf17-9220-6ffb-d69981dd4ef6/00602508874840_Cover.jpg/600x600bb.jpg', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (9, 'Ferrari', 'James Hype, Miggy Dela Rosa', 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/a9/02/ca/a902ca66-530d-d678-077c-17d9da7533ef/22UMGIM36635.rgb.jpg/600x600bb.jpg', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) VALUES (10, 'Cool Down', 'Kolohe Kai', 'https://is1-ssl.mzstatic.com/image/thumb/Music114/v4/5d/5d/f2/5d5df202-ea92-43c4-6eb3-bb5dc5beee06/mzi.qkaoftve.jpg/600x600bb.jpg', 2) ON CONFLICT (id) DO NOTHING;

-- Update template, don't forget to change team_member_id and id as well
UPDATE song SET title = 'POP!', artist = 'NAYEON', album_artwork_url = 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/3f/49/ec/3f49ecb2-cb91-dd28-45b9-a31326d7e63b/738676859614_Cover.jpg/600x600bb.jpg', team_member_id = 2 WHERE id = 10;
UPDATE song SET title = 'Cool Down', artist = 'Kolohe Kai', album_artwork_url = 'https://is1-ssl.mzstatic.com/image/thumb/Music114/v4/5d/5d/f2/5d5df202-ea92-43c4-6eb3-bb5dc5beee06/mzi.qkaoftve.jpg/600x600bb.jpg', team_member_id = 2 WHERE id = 10;