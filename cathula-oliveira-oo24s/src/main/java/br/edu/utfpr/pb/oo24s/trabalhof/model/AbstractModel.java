package br.edu.utfpr.pb.oo24s.trabalhof.model;

import java.io.Serializable;

public interface AbstractModel <ID extends  Serializable> 
            extends Serializable{
    ID getId();
}
