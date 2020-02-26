import { Component, OnInit } from '@angular/core';
import { ContasService } from 'src/app/service/contas.service';

@Component({
  selector: 'app-contas-list',
  templateUrl: './contas-list.component.html',
  styleUrls: ['./contas-list.component.css']
})
export class ContasListComponent implements OnInit {
  contas: Conta[] = [];
  constructor(private service: ContasService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll(){
    this.service.getList().subscribe(res => {
      this.contas = res;
    });
  }

  remove(id: number){
    this.service.delete(id).subscribe(res => {
      this.findAll();
    })
  }

}
