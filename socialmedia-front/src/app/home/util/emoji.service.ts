import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmojiService {

  private emojiFaces: string[] = ["(ㆆ _ ㆆ)", "\tʕっ•ᴥ•ʔっ", "\t( ͡° ᴥ ͡°)", "\t(｡◕‿‿◕｡)", "(⌐■_■)", "(✿◠‿◠)", "༼ つ ◕_◕ ༽つ", "(ง︡'-'︠)ง", "๏̯๏"];
  constructor() { }

  generateEmoji():string {
    const rndInt = Math.floor(Math.random() * 9) + 1;
    return this.emojiFaces[rndInt-1];
  }

}
