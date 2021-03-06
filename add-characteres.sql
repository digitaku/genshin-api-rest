-- Personagem
  INSERT INTO `characters`
    (`id`, `allegiance`, `astrolabe_name`, `birth_day`, `description`, `element`, `img_url`, `name`, `rarity`, `title`, `weapon`)
    VALUES ('', 'Monstadt',
  'Astrolabos',
   '2020-08-31 02:17:47.000000',
    'A mysterious young astrologer who proclaims herself to be \"Astrologist Mona Megistus\" and who possesses abilities to match the title. Erudite, but prideful',
     'Hydro',
      'https://i.ytimg.com/vi/QUioSVENXcI/maxresdefault.jpg',
       'Mona', '5', 'Astral Reflection', 'Catalyst');
-- Habilidades
  INSERT into `ability` (`description`, `name`, `characters_id`) VALUES(
    'Perfome up to 4 water splash attacks that deal Hydro DMG',
    'Normal Attack',
    1
);
-- Upgrade Habilidades
  INSERT INTO `ability_ascension` (`id`, `mora`, `characters_id`, `level`) VALUES (1, '12500','0', '2');
-- Upgrade Personagem
  INSERT INTO `ascension` (`id`, `level`, `mora`, `characters_id`, `variable_item`)
  VALUES ('1', '20', '20000', '1', '3');
-- Itens
  INSERT INTO `item` (`id`, `name`) VALUES ('1', 'Philanemo Mushroom');
  INSERT INTO `item` (`id`, `name`) VALUES ('2', 'Whopperflower Nectar');
  INSERT INTO `item` (`id`, `name`) VALUES ('3', 'Varunada Lazurite Sliver');
  -- Itens para o Upgrade
  INSERT INTO `ascension_items` (`ascension_id`, `item_id`) VALUES ('1', '1');
  INSERT INTO `ascension_items` (`ascension_id`, `item_id`) VALUES ('1', '2');
  INSERT INTO `ascension_items` (`ascension_id`, `item_id`) VALUES ('1', '3');

  -- stats of personagem
  INSERT INTO `stats` (`id`, `atk`, `atk_percentage`, `critical_damage`, `critical_rate`, `def`, `hp`, `level`, `characters_id`)
  VALUES ('', '22', '0', '50', '5', '51', '810', '1', '1');