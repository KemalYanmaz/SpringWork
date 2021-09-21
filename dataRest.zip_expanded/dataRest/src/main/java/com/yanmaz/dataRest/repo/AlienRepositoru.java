package com.yanmaz.dataRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yanmaz.dataRest.model.Alien;

@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface AlienRepositoru extends JpaRepository<Alien,Integer>
{

}
