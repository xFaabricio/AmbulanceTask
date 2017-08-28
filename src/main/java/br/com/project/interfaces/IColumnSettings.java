package br.com.project.interfaces;

import java.util.List;

import br.com.project.models.ColumnSettings;

public interface IColumnSettings<T> extends IGenericDAO<T> {

    public List<ColumnSettings> findByTableName(String simpleName);

}
