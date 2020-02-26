import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router"
import { ContasService } from 'src/app/service/contas.service';
import { CredoresService } from './../../../service/credores.service';

@Component({
  selector: 'app-contas-add',
  templateUrl: './contas-add.component.html',
  styleUrls: ['./contas-add.component.css']
})
export class ContasAddComponent implements OnInit {

  conta: Conta = {} as Conta;

  credores: Credor[] = [];

  constructor(
    private conteService: ContasService,
    private credorService: CredoresService,
    private router: Router
  ) { }

  ngOnInit() {
    this.conta.credor = {} as Credor;
    // this.conta.credor.id = 0;

    this.credorService.getList().subscribe(res => {
      this.credores = res;
    });
  }

  add(){
    console.log('conta:',this.conta);
    this.conteService.save(this.conta).subscribe(response => {
      
      this.router.navigate(['/']);
    });
  }

}
