import { CredoresService } from './../../../service/credores.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class CredorListComponent implements OnInit {

  credores: Credor[] = [];

  constructor(protected service: CredoresService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll(){
    this.service.getList().subscribe(res  =>  {
      this.credores = res;
    });
  }

  remove(id: number){
    this.service.delete(id).subscribe(res => {
      this.findAll();
    })
  }

}
