SELECT U.id_url U.url U.label T.tag FROM urls U, liaison_urls_tags L, tags T, liaison_folded_tags F WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag AND L.id_path = F.id_path


SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag AND L.id_path = F.id_path


SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag AND L.id_path = F.id_path
SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag AND L.id_path = F.id_path AND F.id_parent_tag = T.id_tag


SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag
SELECT * FROM urls U, liaison_url_tags L, tags T WHERE L.id_url = U.id_url AND T.id_tag = L.id_tag



SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE U.id_url = L.id_url AND ( ( L.id_tag = T.id_tag ) OR ( L.id_path = F.id_path AND F.id_parent_tag = T.id_tag ) )



SELECT * FROM urls U, liaison_url_tags L, tags T, liaison_folded_tags F WHERE U.id_url = L.id_url AND ( ( L.id_tag = T.id_tag ) OR ( L.id_path = F.id_path  ) ) ORDER BY `U`.`id_url` ASC


AND F.id_parent_tag = T.id_tag


SELECT * FROM urls U, liaison_url_tags L, liaison_folded_tags F, tags T WHERE L.id_url = 19774 AND L.id_path = F.id_path AND F.id_tag = T.id_tag
SELECT * FROM liaison_url_tags L, liaison_folded_tags F, tags T WHERE L.id_url = 19774 AND L.id_path = F.id_path AND F.id_tag = T.id_tag
SELECT * FROM liaison_url_tags L, liaison_folded_tags F, tags T WHERE L.id_url = 19779 AND L.id_path = F.id_path AND F.id_parent_tag = T.id_tag