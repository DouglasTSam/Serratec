select a.nome,g2.nome from artista_genero ag  
	inner join artista a 
		on a.id  = ag.id_artista 
	inner join genero g2
		on ag.id_genero  = g2.id  
where ag.id_artista = 23
