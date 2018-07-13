use AGENCIA;

-- Seleciona a media dos valores de acomodações 5 estrelas dos lugares cadastrados
SELECT E.local_destino, AVG(E.valor)
FROM  
	servico_ref E join  acomodacao C
    on C.codigo = E.codigo
where
C.no_estrelas = 5

GROUP BY E.local_destino;

-- seleciona os parceiros que oferecem intercambio de estudo 
SELECT X.nome_fantasia
FROM  
	servico_ref E join  intercambio C join servico_parceiro D join oferece A join parceiro X
    on C.codigo = E.codigo and C.codigo = D.codigo and A.codigo = D.codigo and  X.CNPJ = A.CNPJ
where
C.tipo = 2 #estudo
;

-- 


