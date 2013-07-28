package bot.methodes;

public class Text {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			/*function AddMistakes(Orig: string; Chance: Integer): string;
			var
			  Line1, Line2, Line: array [0..3] of string;
			  i, j, TPos, Prob, Mist, L: Integer;
			  Norm, Caps, Excp, TLine, NewKey: string;
			begin
			  Result := '';
			  Norm := '`1234567890-=qwertyuiop[]\asdfghjkl;''zxcvbnm,./';
			  Caps := '~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM<>?';
			  Excp := '`1234567890-=[]\;'',./~!@#$%^&*()_+{}|:"<>?';
			  Line1[0] := '`1234567890-= ';     Line2[0] := '~!@#$%^&*()_+ ';
			  Line1[1] := ' qwertyuiop[]\';     Line2[1] := ' QWERTYUIOP{}|';
			  Line1[2] := ' asdfghjkl;''  ';    Line2[2] := ' ASDFGHJKL:"  ';
			  Line1[3] := ' zxcvbnm,./   ';     Line2[3] := ' ZXCVBNM<>?   ';
			  L := Length(Orig);
			  for i := 1 to L do
			  begin
			    Prob := Chance;
			    Prob := Prob + Mist;     //More mistakes = less chance of another mistake
			    if (Pos(Orig[i], Excp) <> 0) then Prob := Prob - 2;  //If char is hard to type (numbers/symbols) - more chance
			    if (i = 1) then Prob := Prob + 5; //The first letter - less chance
			    if (Orig[i] <> ' ') and (Random(Max(Prob, 0)) = 0) then
			    begin
			      if (Pos(Orig[i], Norm) <> 0) then
			        Line := Line1
			      else
			      if (Pos(Orig[i], Caps) <> 0) then
			        Line := Line2;
			      for j := 0 to 3 do
			      begin
			        TPos := Pos(Orig[i], Line[j]);
			        if (TPos <> 0) then
			          case Random(19) of
			            0..5:                              //Same line
			            begin
			              TLine := Line[j];
			              try
			                NewKey := TLine[TPos - 1 + Random(3)];
			              except end;
			              if (NewKey = '') or (NewKey = ' ') then
			                NewKey := TLine[TPos];
			            end;
			            6..8:                                        //Line above
			            begin
			              TLine := Line[Max(j - 1, 0)];
			              try
			                NewKey := Line[j - 1][TPos + Random(2)];
			              except end;
			              if (NewKey = '') or (NewKey = ' ') then
			                NewKey := TLine[TPos];
			            end;
			            9..11:                                      //Line below
			            begin
			              TLine := Line[Min(j + 1, High(Line))];
			              try
			                NewKey := TLine[TPos - 1 + Random(2)];     //Wrong case
			              except end;
			              if (NewKey = '') or (NewKey = ' ') then
			                NewKey := TLine[TPos];
			            end;
			            12..16:
			            begin
			              if (i - 1 >= 1) then
			              begin
			                if (Pos(Orig[i - 1], Caps) <> 0) then
			                  NewKey := Line2[j][TPos]
			                else
			                if (Pos(Orig[i - 1], Norm) <> 0) then
			                  NewKey := Line1[j][TPos]
			              end else
			              if (i + 1 <= Length(Orig)) then
			              begin
			                if (Pos(Orig[i + 1], Caps) <> 0) then
			                  NewKey := Line2[j][TPos]
			                else
			                if (Pos(Orig[i + 1], Norm) <> 0) then
			                  NewKey := Line1[j][TPos];
			              end;
			            end;
			            17, 18: if (i <> 1) then NewKey := '';         //Missing letters
			          end;
			      end;
			    end else
			      NewKey := Orig[i];
			    if (NewKey <> Orig[i]) then Inc(Mist);
			    Result := Result + NewKey;
			  end;
			end;*/

			
			
			/*(*
			FindTextEx
			~~~~~~~~~~

			.. code-block:: pascal

			    function FindTextEx(var cx, cy: Integer; txt,font: TStringArray; xs, ys, xe, ye: Integer): Boolean;

			Searches for text or texts in specified box with specified font or fonts returns
			true on first find of one of the texts with one of the fonts in the specified
			box, returns x, y values aswell.

			.. note::

			    by Stupid3ooo, modified by LordJashin

			Example:

			.. code-block:: pascal

			    var
			      x, y, w, h: Integer;
			      fonts, txts: TStringArray;
			    begin
			      fonts := ['MyOwnFontSet', 'SmallCharacters'];
			      txts := ['Simba', 'HakunaMatata'];

			      SetDesktopAsClient;
			      GetClientDimensions(w, h);

			      if FindTextEx(x, y, txts, fonts, 0, 0, w - 1, h - 1) then
			        MoveMouse(x, y);
			    end.
			*)

			function FindTextEx(var cx, cy: Integer; txt, fonts: TStringArray; xs, ys, xe, ye: Integer): Boolean;
			var
			  s, j, i: Integer;
			begin
			  for j := 0 to High(txt) do
			    for i := 0 to High(fonts) do
			    begin
			      s := CreateBitmapMaskFromText(ToStr(txt[j]), ToStr(fonts[i]));

			      if (xs < 0) then xs := 0;
			      if (ys < 0) then ys := 0;

			      Result := FindBitmapMaskTolerance(S, cx, cy, xs, ys, xe, ye, 30, 30);
			      FreeBitmap(S);

			      if (result) then
			        exit;
			    end;
			end;

			(*
			FindText
			~~~~~~~~

			.. code-block:: pascal

			    function FindText(var cx, cy: Integer; txt,font: string; xs, ys, xe, ye: Integer): Boolean;

			Searches for text in specified box with specified font.

			.. note::

			    by Coh3n

			Example:

			.. code-block:: pascal

			*)
			function FindText(var cx, cy: integer; txt, font: string; xs, ys, xe, ye: integer): boolean;
			begin
			  result := findTextEx(cx, cy, [txt], [font], xs, ys, xe, ye);
			end;
*/
			
	
}

