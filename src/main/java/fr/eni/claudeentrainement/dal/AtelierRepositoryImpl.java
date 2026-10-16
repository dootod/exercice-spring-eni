package fr.eni.claudeentrainement.dal;

import fr.eni.claudeentrainement.bo.Atelier;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AtelierRepositoryImpl implements AtelierRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AtelierRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Atelier> findAll() {
        String sql = "SELECT numero, nom FROM Ateliers";

        List<Atelier> ateliers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Atelier.class));
        return ateliers;
    }

    @Override
    public void insert(Atelier atelier) {
        String sql = "INSERT INTO Ateliers (numero, nom) VALUES (:numero, :nom)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("numero", atelier.getNumero());
        parameterSource.addValue("nom", atelier.getNom());

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int deleteById(Integer numero) {
        String sql = "DELETE FROM Ateliers WHERE numero = :numero";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("numero", numero);

        int deleted = jdbcTemplate.update(sql, parameterSource);

        return deleted;
    }

    @Override
    public Optional<Atelier> findById(Integer numero) {
        String sql = "SELECT numero, nom FROM Ateliers WHERE numero = :numero";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("numero", numero);

        Optional<Atelier> atelierOptional;

        try {
            atelierOptional = Optional.ofNullable(
                jdbcTemplate.queryForObject(
                    sql, parameterSource, new BeanPropertyRowMapper<>(Atelier.class)
                )
            );
        } catch (EmptyResultDataAccessException e) {
            atelierOptional = Optional.empty();
        }

        return atelierOptional;
    }
}
